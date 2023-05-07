create database chat_bot;

use chat_bot;

create table t_command
(
    id          bigint(11) unsigned auto_increment primary key comment '主键id',
    name        varchar(30) not null unique comment '指令名称',
    description text comment '指令描述',
    base_prompt text comment '基础提示词',
    command     varchar(100) comment '指令',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '更新时间'
) default charset 'utf8mb4';

create table t_bot
(
    id         bigint(11) unsigned auto_increment primary key comment '主键id',
    name       varchar(30) not null unique comment '机器人名称',
    command_id bigint(11) comment '指令id',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '更新时间'
) default charset 'utf8mb4';

create table t_command_training
(
    id          bigint(11) unsigned auto_increment primary key comment '主键id',
    name        varchar(30) not null unique comment '指令名称',
    base_prompt text comment '基础提示词',
    custom_content text comment '自定义文本',
    create_time timestamp default current_timestamp comment '创建时间',
    update_time timestamp default current_timestamp on update current_timestamp comment '更新时间'
) default charset 'utf8mb4';
