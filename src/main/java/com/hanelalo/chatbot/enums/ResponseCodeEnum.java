package com.hanelalo.chatbot.enums;

public enum ResponseCodeEnum {
    SUCCESS(0,"success"),
    API_KEY_INVALID(10000, "OpenAI API Key不能为空"),
    ARGUMENT_ERROR(10001,"参数错误:"),
    COMMAND_EXISTS(10002, "指令编码已存在"),
    COMMAND_NOT_EXISTS(10003, "指令不存在");

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
