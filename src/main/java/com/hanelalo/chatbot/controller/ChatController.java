package com.hanelalo.chatbot.controller;

import cn.hutool.core.util.StrUtil;
import com.hanelalo.chatbot.domain.AnswerMessageDto;
import com.hanelalo.chatbot.domain.ChatMessageDTO;
import com.hanelalo.chatbot.domain.Response;
import com.hanelalo.chatbot.enums.ResponseCodeEnum;
import com.hanelalo.chatbot.exception.ChatBotException;
import com.hanelalo.chatbot.service.ChatService;
import com.theokanning.openai.completion.chat.ChatMessage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public Response<AnswerMessageDto> chat(@RequestBody @Validated ChatMessageDTO chatMessageDto){
        ChatMessage chatMessage = chatService.chat(chatMessageDto);
        return Response.success(convertToDto(chatMessage));
    }

    private AnswerMessageDto convertToDto(ChatMessage chatMessage) {
        AnswerMessageDto dto = new AnswerMessageDto();
        dto.setRole(chatMessage.getRole());
        dto.setContent(chatMessage.getContent());
        return dto;
    }

}
