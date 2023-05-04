package com.hanelalo.chatbot.domain;

import com.hanelalo.chatbot.enums.ResponseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

    private int code;
    private String message;
    private T data;

    public static <T> Response<T> success(T data) {
        return new Response<>(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage(), data);
    }

    public static Response<?> failed(int code, String message) {
        return new Response<>(code, message, null);
    }

}
