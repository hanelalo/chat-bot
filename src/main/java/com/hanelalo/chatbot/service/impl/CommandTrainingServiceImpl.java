package com.hanelalo.chatbot.service.impl;

import com.hanelalo.chatbot.model.dto.AddCommandTrainingDTO;
import com.hanelalo.chatbot.model.entity.CommandTraining;
import com.hanelalo.chatbot.mapper.CommandTrainingMapper;
import com.hanelalo.chatbot.service.CommandTrainingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanelalo
 * @since 2023-05-06
 */
@Service
public class CommandTrainingServiceImpl extends ServiceImpl<CommandTrainingMapper, CommandTraining> implements CommandTrainingService {

    @Override
    public void add(AddCommandTrainingDTO dto) {

    }
}
