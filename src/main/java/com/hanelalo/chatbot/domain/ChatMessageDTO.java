package com.hanelalo.chatbot.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class ChatMessageDTO {

    private String role;
    @NotBlank(message = "请输入您的问题")
    private String prompt;

}
