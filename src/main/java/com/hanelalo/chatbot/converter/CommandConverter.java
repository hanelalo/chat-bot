package com.hanelalo.chatbot.converter;

import com.hanelalo.chatbot.model.dto.CommandDTO;
import com.hanelalo.chatbot.model.entity.Command;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommandConverter {
    CommandConverter INSTANCE = Mappers.getMapper(CommandConverter.class);

    CommandDTO toDto(Command command);
}
