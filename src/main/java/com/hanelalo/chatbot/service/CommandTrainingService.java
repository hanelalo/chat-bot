package com.hanelalo.chatbot.service;

import com.hanelalo.chatbot.model.dto.AddCommandTrainingDTO;
import com.hanelalo.chatbot.model.entity.CommandTraining;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanelalo
 * @since 2023-05-06
 */
public interface CommandTrainingService extends IService<CommandTraining> {

    void add(AddCommandTrainingDTO dto);
}
