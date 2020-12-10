package com.oycbest.springbootswagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description 用户测试控制类
 * @Author oyc
 * @Date 2020/12/10 16:36
 * @Version
 */
@RestController
@RequestMapping("user")
@Api(tags = "UserController", description = "UserController | 测试swagger")
public class UserController {

    @GetMapping
    @ApiOperation(value = "获取用户列表方法", notes = "UserController测试方法-list")
    public String list(String name) {
        return "user list：" + name;
    }

    @GetMapping("{userId}")
    @ApiOperation(value = "根据用户id获取用户信息", notes = "UserController测试方法-user")
    public String user(@PathVariable String userId) {
        return "user id：" + userId;
    }

    @PostMapping
    @ApiOperation(value = "保存用户信息", notes = "UserController测试方法-save")
    public String save(String name) {
        return "save user：" + name;
    }

    @DeleteMapping("{userId}")
    @ApiOperation(value = "删除用户信息", notes = "UserController测试方法-del")
    public String del(@PathVariable String userId) {
        return "del id：" + userId;
    }
}