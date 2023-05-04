package com.hanelalo.chatbot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "chatbot.proxy")
@Configuration
@Data
public class ProxyConfig {

    private String host;
    private int port;

}
