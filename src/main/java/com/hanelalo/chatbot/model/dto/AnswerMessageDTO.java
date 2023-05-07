package com.hanelalo.chatbot.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("chat回应信息")
public class AnswerMessageDTO {

    @ApiModelProperty("角色")
    private String role;
    @ApiModelProperty("回应内容")
    private String content;

}
