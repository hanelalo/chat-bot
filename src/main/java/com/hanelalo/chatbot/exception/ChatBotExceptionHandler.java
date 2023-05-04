package com.hanelalo.chatbot.exception;

import com.hanelalo.chatbot.domain.Response;
import com.hanelalo.chatbot.enums.ResponseCodeEnum;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ChatBotExceptionHandler {

    @ExceptionHandler(ChatBotException.class)
    public Response<?> handle(ChatBotException e) {
        return Response.failed(e.getCode(), e.getMessage());
    }


    @ExceptionHandler(BindException.class)
    public Response<?> handleBindException(BindException e) {
        return Response.failed(ResponseCodeEnum.ARGUMENT_ERROR.getCode(),
                ResponseCodeEnum.ARGUMENT_ERROR.getMessage() + e.getFieldErrors().get(0).getDefaultMessage());
    }

}
