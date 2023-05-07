package com.hanelalo.chatbot.openai;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Data
public class ChatContext {

    private final String uuid = UUID.randomUUID().toString().replace("-", "");

    private List<ChatMessage> messages = new ArrayList<>();

    private String model = "gpt-3.5-turbo";

    private Double temperature = 0D;

    public void add(ChatMessage chatMessage) {
        messages.add(chatMessage);
    }

    public ChatCompletionRequest chatCompletionRequest(ChatMessage chatMessage) {
        add(chatMessage);
        ChatCompletionRequest request = ChatCompletionRequest.builder().presencePenalty(0.0).frequencyPenalty(1.0).user(chatMessage.getRole()).model(model).messages(messages).temperature(temperature).build();
        HashMap<String, Integer> logitBias = new HashMap<>();
        logitBias.put("2435", -100);
        request.setLogitBias(logitBias);
        return request;
    }
}
