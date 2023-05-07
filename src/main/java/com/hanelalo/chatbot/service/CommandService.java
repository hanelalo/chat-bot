package com.hanelalo.chatbot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanelalo.chatbot.model.dto.AddCommandDTO;
import com.hanelalo.chatbot.model.dto.CommandDTO;
import com.hanelalo.chatbot.model.dto.ModifyCommandDTO;
import com.hanelalo.chatbot.model.dto.QueryCommandDTO;
import com.hanelalo.chatbot.model.entity.Command;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanelalo
 * @since 2023-05-06
 */
public interface CommandService extends IService<Command> {

    void add(AddCommandDTO dto);

    List<CommandDTO> queryList(QueryCommandDTO dto);

    void modify(long id, ModifyCommandDTO dto);

    void delete(long id);
}
