package com.hanelalo.chatbot.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hanelalo.chatbot.enums.ResponseCodeEnum;
import com.hanelalo.chatbot.exception.ChatBotException;
import com.hanelalo.chatbot.model.dto.ChatMessageDTO;
import com.hanelalo.chatbot.model.entity.Command;
import com.hanelalo.chatbot.openai.ChatContext;
import com.hanelalo.chatbot.openai.ChatContextHolder;
import com.hanelalo.chatbot.openai.OpenAIClient;
import com.hanelalo.chatbot.service.ChatService;
import com.hanelalo.chatbot.service.CommandService;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final OpenAIClient openAIClient;
    private final CommandService commandService;

    public ChatServiceImpl(OpenAIClient openAIClient, CommandService commandService) {
        this.openAIClient = openAIClient;
        this.commandService = commandService;
    }

    @Override
    public ChatMessage chat(ChatMessageDTO chatMessageDto) {
        initContext();
        ChatContext context = ChatContextHolder.get();
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRole(StrUtil.isBlankIfStr(chatMessageDto.getRole()) ? "user" : chatMessageDto.getRole());
        String content = getContent(chatMessageDto);
        chatMessage.setContent(content);
        log.debug("对话{}有来自{}的新内容：{}", context.getUuid(), chatMessage.getRole(), chatMessage.getContent());
        ChatCompletionRequest request = context.chatCompletionRequest(chatMessage);
        ChatCompletionResult result = openAIClient.chat(request);
        ChatMessage message = result.getChoices().get(0).getMessage();
        ChatContextHolder.get().add(message);
        log.debug("对话{}收到新回复：{}", context.getUuid(), message.getContent());
        return message;
    }

    private String getContent(ChatMessageDTO dto){
        if (StrUtil.isBlank(dto.getCommand())) {
            return dto.getPrompt();
        }
        QueryWrapper<Command> wrapper = new QueryWrapper<>();
        wrapper.eq("command", dto.getCommand());
        Command command = commandService.getOne(wrapper);
        if (Objects.isNull(command)) {
            throw new ChatBotException(ResponseCodeEnum.COMMAND_NOT_EXISTS);
        }
        return command.getBasePrompt().replace("{{text}}", dto.getPrompt());
    }

    private void initContext() {
        if (Objects.nonNull(ChatContextHolder.get())) {
            return;
        }
        ChatContext context = new ChatContext();
        ChatContextHolder.set(context);
    }
}
