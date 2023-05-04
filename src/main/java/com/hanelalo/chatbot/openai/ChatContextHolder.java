package com.hanelalo.chatbot.openai;

public class ChatContextHolder {

    private static final ThreadLocal<ChatContext> THREAD_LOCAL = new ThreadLocal<>();

    public static ChatContext get(){
        return THREAD_LOCAL.get();
    }

    public static void set(ChatContext context){
        THREAD_LOCAL.set(context);
    }

}
