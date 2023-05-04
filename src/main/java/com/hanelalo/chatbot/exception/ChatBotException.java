package com.hanelalo.chatbot.exception;

import com.hanelalo.chatbot.enums.ResponseCodeEnum;
import lombok.Getter;

@Getter
public class ChatBotException extends RuntimeException{

    private final int code;
    private final String message;

    public ChatBotException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ChatBotException(ResponseCodeEnum responseCodeEnum) {
        super(responseCodeEnum.getMessage());
        this.code = responseCodeEnum.getCode();
        this.message = responseCodeEnum.getMessage();
    }
}
