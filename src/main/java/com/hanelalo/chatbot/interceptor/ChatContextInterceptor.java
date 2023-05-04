package com.hanelalo.chatbot.interceptor;

import com.hanelalo.chatbot.openai.ChatContext;
import com.hanelalo.chatbot.openai.ChatContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ChatContextInterceptor implements HandlerInterceptor {

    public static final String CHAT_BOT_CONTEXT = "CHAT_BOT_CONTEXT";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object value = request.getSession().getAttribute(CHAT_BOT_CONTEXT);
        ChatContextHolder.set((ChatContext) value);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(ChatContextHolder.get() == null){
            request.getSession().removeAttribute(CHAT_BOT_CONTEXT);
        }else{
            request.getSession().setAttribute(CHAT_BOT_CONTEXT, ChatContextHolder.get());
        }
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
