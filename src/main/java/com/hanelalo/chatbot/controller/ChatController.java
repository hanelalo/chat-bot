package com.hanelalo.chatbot.controller;

import com.hanelalo.chatbot.enums.RespConstants;
import com.hanelalo.chatbot.model.dto.AnswerMessageDTO;
import com.hanelalo.chatbot.model.dto.ChatMessageDTO;
import com.hanelalo.chatbot.model.dto.Response;
import com.hanelalo.chatbot.openai.ChatContext;
import com.hanelalo.chatbot.openai.ChatContextHolder;
import com.hanelalo.chatbot.service.ChatService;
import com.theokanning.openai.completion.chat.ChatMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Api(value = "chat服务", tags = "交互服务：chat")
@RestController
@RequestMapping("chat")
@Slf4j
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @ApiOperation("对话接口")
    @PostMapping
    public Response<AnswerMessageDTO> chat(@RequestBody @Validated ChatMessageDTO chatMessageDto) {
        ChatMessage chatMessage = chatService.chat(chatMessageDto);
        return Response.success(convertToDto(chatMessage));
    }

    @ApiOperation("重置对话")
    @GetMapping("reset")
    public Response<String> reset() {
        ChatContext context = ChatContextHolder.get();
        if(Objects.nonNull(context)) {
            log.info("对话{}已重置", context.getUuid());
            ChatContextHolder.set(null);
        }
        return Response.success(RespConstants.SUCCESS);
    }

    private AnswerMessageDTO convertToDto(ChatMessage chatMessage) {
        AnswerMessageDTO dto = new AnswerMessageDTO();
        dto.setRole(chatMessage.getRole());
        dto.setContent(chatMessage.getContent());
        return dto;
    }

}
