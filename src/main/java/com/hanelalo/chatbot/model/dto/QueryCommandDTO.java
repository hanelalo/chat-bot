package com.hanelalo.chatbot.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("指令查询条件")
@Data
public class QueryCommandDTO {

    /**
     * id
     */
    @ApiModelProperty(value = "指令id",example = "1")
    private Long id;

    /**
     * 指令名称
     */
    @ApiModelProperty(value = "指令名称，可模糊查询",example = "翻译")
    private String name;

    /**
     * 指令编码
     */
    @ApiModelProperty(value = "指令编码，可模糊查询",example = "translate")
    private String command;

}
