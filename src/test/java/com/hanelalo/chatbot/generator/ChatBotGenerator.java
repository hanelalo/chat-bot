package com.hanelalo.chatbot.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

public class ChatBotGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/chat_bot", "root", "123456")
                .globalConfig(builder -> builder.author("hanelalo").outputDir("/Users/hanelalo/develop/chat-bot/src/main/java"))
                .packageConfig(builder -> builder.parent("com.hanelalo.chatbot").entity("model.entity"))
                .strategyConfig(builder -> builder.addInclude("t_command", "t_bot", "t_command_training")
                        .addTablePrefix("t_"))
                .strategyConfig(builder -> builder
                        .serviceBuilder().formatServiceFileName("%1$sService").formatServiceImplFileName("%1$sServiceImpl").enableFileOverride())
                .strategyConfig(builder ->
                        builder.mapperBuilder().enableBaseColumnList().enableBaseResultMap().enableFileOverride())
                .strategyConfig(builder ->
                        builder.controllerBuilder().enableFileOverride())
                .strategyConfig(builder ->
                        builder.entityBuilder().enableFileOverride().enableLombok())
                .execute();

    }

}
