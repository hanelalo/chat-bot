package com.hanelalo.chatbot.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
@ApiModel("chat信息")
public class ChatMessageDTO {

    @ApiModelProperty("指令代码")
    private String command;
    @ApiModelProperty("角色")
    private String role;
    @NotBlank(message = "请输入您的问题")
    @ApiModelProperty("用户自由文本")
    private String prompt;

}
