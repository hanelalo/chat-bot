package com.hanelalo.chatbot.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author hanelalo
 * @since 2023-05-06
 */
@Getter
@Setter
@TableName("t_command")
public class Command implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 指令名称
     */
    private String name;

    /**
     * 指令描述
     */
    private String description;

    /**
     * 基础提示词
     */
    private String basePrompt;

    /**
     * 指令
     */
    private String command;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
