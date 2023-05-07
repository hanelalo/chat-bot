package com.hanelalo.chatbot.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanelalo.chatbot.converter.CommandConverter;
import com.hanelalo.chatbot.enums.ResponseCodeEnum;
import com.hanelalo.chatbot.exception.ChatBotException;
import com.hanelalo.chatbot.mapper.CommandMapper;
import com.hanelalo.chatbot.model.dto.AddCommandDTO;
import com.hanelalo.chatbot.model.dto.CommandDTO;
import com.hanelalo.chatbot.model.dto.ModifyCommandDTO;
import com.hanelalo.chatbot.model.dto.QueryCommandDTO;
import com.hanelalo.chatbot.model.entity.Command;
import com.hanelalo.chatbot.service.CommandService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hanelalo
 * @since 2023-05-06
 */
@Service
public class CommandServiceImpl extends ServiceImpl<CommandMapper, Command> implements CommandService {

    @Override
    public void add(AddCommandDTO dto) {
        QueryWrapper<Command> wrapper = new QueryWrapper<>();
        wrapper.eq("command", dto.getCommand());
        if (baseMapper.exists(wrapper)) {
            throw new ChatBotException(ResponseCodeEnum.COMMAND_EXISTS);
        }
        Command command = new Command();
        command.setName(dto.getName());
        command.setDescription(dto.getDescription());
        command.setBasePrompt(dto.getBasePrompt());
        command.setCommand(dto.getCommand());
        command.setCreateTime(LocalDateTime.now());
        command.setUpdateTime(LocalDateTime.now());
        save(command);
    }

    @Override
    public List<CommandDTO> queryList(QueryCommandDTO dto) {
        QueryWrapper<Command> wrapper = new QueryWrapper<>();
        if (Objects.nonNull(dto.getId())) {
            wrapper.eq("id", dto.getId());
        }
        if (StrUtil.isNotBlank(dto.getCommand())) {
            wrapper.like("command", dto.getCommand());
        }
        if (StrUtil.isNotBlank(dto.getName())) {
            wrapper.like("name", dto.getName());
        }
        List<Command> commands = list(wrapper);
        return commands.stream().map(CommandConverter.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public void modify(long id, ModifyCommandDTO dto) {
        Command command = getById(id);
        if(Objects.isNull(command)){
            throw new ChatBotException(ResponseCodeEnum.COMMAND_NOT_EXISTS);
        }
        command.setName(dto.getName());
        command.setDescription(dto.getDescription());
        command.setBasePrompt(dto.getBasePrompt());
        command.setUpdateTime(LocalDateTime.now());
        updateById(command);
    }

    @Override
    public void delete(long id) {
        removeById(id);
    }

}
