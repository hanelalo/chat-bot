package com.hanelalo.chatbot.service;

import com.hanelalo.chatbot.model.dto.ChatMessageDTO;
import com.theokanning.openai.completion.chat.ChatMessage;

public interface ChatService {

    ChatMessage chat(ChatMessageDTO chatMessageDto);
}
