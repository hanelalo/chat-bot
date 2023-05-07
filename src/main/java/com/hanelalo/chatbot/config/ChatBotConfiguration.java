package com.hanelalo.chatbot.config;

import com.hanelalo.chatbot.interceptor.ChatContextInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableAspectJAutoProxy
@MapperScan(basePackages = "com.hanelalo.chatbot.mapper")
public class ChatBotConfiguration extends WebMvcConfigurationSupport {

    private final ChatContextInterceptor chatContextInterceptor;

    public ChatBotConfiguration(ChatContextInterceptor chatContextInterceptor) {
        this.chatContextInterceptor = chatContextInterceptor;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(chatContextInterceptor);
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").
                addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
