package com.hanelalo.chatbot.factory;

import cn.hutool.core.util.StrUtil;
import com.hanelalo.chatbot.exception.ChatBotException;
import com.hanelalo.chatbot.enums.ResponseCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class ApiKeyFactoryImpl implements ApiKeyFactory{

    private static final String OPENAI_API_KEY = "OPENAI_API_KEY";
    private String apiKey;
    @Override
    public String get(){
        return apiKey;
    }

    @PostConstruct
    public void init(){
        String apiKey = System.getenv(OPENAI_API_KEY);
        if (StrUtil.isBlankIfStr(apiKey)) {
            log.error("OPENAI_API_KEY 未设置");
            throw new ChatBotException(ResponseCodeEnum.API_KEY_INVALID);
        }
        this.apiKey = apiKey;
    }

}
