package com.hanelalo.chatbot.model.dto;

import com.hanelalo.chatbot.enums.ResponseCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("响应信息")
public class Response<T> {

    @ApiModelProperty("响应码")
    private int code;
    @ApiModelProperty("响应描述")
    private String message;
    @ApiModelProperty("响应数据")
    private T data;

    public static <T> Response<T> success(T data) {
        return new Response<>(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage(), data);
    }

    public static Response<?> failed(int code, String message) {
        return new Response<>(code, message, null);
    }

}
