package com.hanelalo.chatbot.controller;

import com.hanelalo.chatbot.enums.RespConstants;
import com.hanelalo.chatbot.model.dto.*;
import com.hanelalo.chatbot.service.CommandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hanelalo
 * @since 2023-05-06
 */
@Api(value = "命令管理", tags = "基础组件管理：命令")
@RestController
@RequestMapping("/command")
public class CommandController {

    @Autowired
    private CommandService commandService;

    @PostMapping
    @ApiOperation("新增命令")
    public Response<String> add(@RequestBody @Validated AddCommandDTO dto) {
        commandService.add(dto);
        return Response.success(RespConstants.SUCCESS);
    }

    @GetMapping("list")
    @ApiOperation("查询所有命令")
    public Response<List<CommandDTO>> queryAll(QueryCommandDTO dto){
        return Response.success(commandService.queryList(dto));
    }

    @PutMapping("/{id}")
    @ApiOperation("更新命令")
    public Response<String> modify(@PathVariable("id") long id, @RequestBody ModifyCommandDTO dto) {
        commandService.modify(id, dto);
        return Response.success(RespConstants.SUCCESS);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除命令")
    public Response<String> delete(@PathVariable("id") long id) {
        commandService.delete(id);
        return Response.success(RespConstants.SUCCESS);
    }

}
