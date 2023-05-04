package com.hanelalo.chatbot.service.impl;

import cn.hutool.core.util.StrUtil;
import com.hanelalo.chatbot.domain.ChatMessageDTO;
import com.hanelalo.chatbot.openai.ChatContext;
import com.hanelalo.chatbot.openai.ChatContextHolder;
import com.hanelalo.chatbot.openai.OpenAIClient;
import com.hanelalo.chatbot.service.ChatService;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ChatServiceImpl implements ChatService {

    private final OpenAIClient openAIClient;

    public ChatServiceImpl(OpenAIClient openAIClient) {
        this.openAIClient = openAIClient;
    }

    @Override
    public ChatMessage chat(ChatMessageDTO chatMessageDto) {
        initContext();
        ChatContext context = ChatContextHolder.get();
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRole(StrUtil.isBlankIfStr(chatMessageDto.getRole()) ? "user" : chatMessageDto.getRole());
        chatMessage.setContent(chatMessageDto.getPrompt());
        ChatCompletionRequest request = context.chatCompletionRequest(chatMessage);
        ChatCompletionResult result = openAIClient.chat(request);
        ChatMessage message = result.getChoices().get(0).getMessage();
        ChatContextHolder.get().add(message);
        return message;
    }

    private void initContext() {
        if (Objects.nonNull(ChatContextHolder.get())) {
            return;
        }
        ChatContext context = new ChatContext();
        ChatContextHolder.set(context);
    }
}
