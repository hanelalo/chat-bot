package com.hanelalo.chatbot.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanelalo.chatbot.factory.ApiKeyFactory;
import com.theokanning.openai.OpenAiApi;
import com.theokanning.openai.service.OpenAiService;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.time.Duration;

import static com.theokanning.openai.service.OpenAiService.defaultClient;
import static com.theokanning.openai.service.OpenAiService.defaultRetrofit;

@Configuration
public class OpenAiConfiguration {

    @Bean
    public Proxy proxy(ProxyConfig proxyConfig){
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyConfig.getHost(), proxyConfig.getPort()));
    }

    @Bean
    public OkHttpClient okHttpClient(Proxy proxy, ApiKeyFactory factory) {
        return defaultClient(factory.get(), Duration.ofSeconds(10)).newBuilder().proxy(proxy).build();
    }

    @Bean
    public OpenAiService openAiService(OkHttpClient okHttpClient, ObjectMapper objectMapper){
        Retrofit retrofit = defaultRetrofit(okHttpClient, objectMapper);
        OpenAiApi openAiApi = retrofit.create(OpenAiApi.class);
        return new OpenAiService(openAiApi);
    }

}
