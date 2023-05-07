package com.hanelalo.chatbot.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 命令信息
 */
@Data
@ApiModel("命令信息")
public class CommandDTO {

    /**
     * 主键id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 指令名称
     */
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
    private String command;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;
}
