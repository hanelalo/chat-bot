package com.hanelalo.chatbot.controller;

import com.hanelalo.chatbot.enums.RespConstants;
import com.hanelalo.chatbot.model.dto.AddCommandTrainingDTO;
import com.hanelalo.chatbot.model.dto.Response;
import com.hanelalo.chatbot.service.CommandTrainingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hanelalo
 * @since 2023-05-06
 */
@Api(value = "命令训练管理",tags = "基础组件管理：命令训练")
@RestController
@RequestMapping("/commandTraining")
public class CommandTrainingController {

    @Autowired
    private CommandTrainingService commandTrainingService;

    @PostMapping
    @ApiOperation("新增命令训练计划")
    public Response<String> add(@RequestBody AddCommandTrainingDTO dto){
        commandTrainingService.add(dto);
        return Response.success(RespConstants.SUCCESS);
    }


}
