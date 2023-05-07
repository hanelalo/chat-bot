package com.hanelalo.chatbot.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("修改命令请求信息")
@Data
public class ModifyCommandDTO {
    @ApiModelProperty("命令名称")
    private String name;
    @ApiModelProperty("基础提示词")
    private String basePrompt;
    @ApiModelProperty("命令描述")
    private String description;
}
