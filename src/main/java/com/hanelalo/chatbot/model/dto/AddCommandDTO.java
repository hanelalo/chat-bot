package com.hanelalo.chatbot.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@ApiModel("新增指令请求")
public class AddCommandDTO {

    /**
     * 指令名称
     */
    @NotBlank(message = "请填写指令名称")
    @Length(max = 30,message = "名称长度不能超过30")
    @ApiModelProperty("指令名称")
    private String name;

    /**
     * 指令描述
     */
    @ApiModelProperty("指令描述")
    private String description;

    /**
     * 基础提示词
     */
    @ApiModelProperty("基础提示词")
    private String basePrompt;

    /**
     * 指令
     */
    @ApiModelProperty("指令编码")
    @NotBlank(message = "定填写指令编码")
    @Length(max = 100, message = "指令编码长度不能超过100")
    @Pattern(regexp = "[0-9a-zA-Z_-]{1,100}",message = "指令编码只能包含数字、大小写字母、\"_\"、\"-\"")
    private String command;

}
