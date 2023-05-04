package com.hanelalo.chatbot.openai;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.stereotype.Component;

@Component
public class OpenAIClient {

    private final OpenAiService openAiService;

    public OpenAIClient(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    public ChatCompletionResult chat(ChatCompletionRequest request){
         return openAiService.createChatCompletion(request);
    }

}
