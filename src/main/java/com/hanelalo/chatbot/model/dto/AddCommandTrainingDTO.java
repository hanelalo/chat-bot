package com.hanelalo.chatbot.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel("增加命令训练计划")
@Data
public class AddCommandTrainingDTO {

    /**
     * 指令名称
     */
    @ApiModelProperty("指令名称")
    @NotBlank(message = "请填写指令名称")
    private String name;

    /**
     * 基础提示词
     */
    @ApiModelProperty("基础提示词")
    private String basePrompt;

    /**
     * 自定义文本
     */
    @ApiModelProperty("自定义文本，用于训练时替换基础提示词中的用户自由文本")
    private String customContent;

}
