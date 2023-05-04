package com.hanelalo.chatbot.enums;

public enum ResponseCodeEnum {
    SUCCESS(0,"success"),
    API_KEY_INVALID(10000, "OpenAI API Key不能为空"),
    ARGUMENT_ERROR(10001,"参数错误:");

    private final int code;
    private final String message;

    ResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
