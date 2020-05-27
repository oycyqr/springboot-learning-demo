package com.oycbest.springbootswagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Description: 测试swagger controller
 * @Author oyc
 * @Date 2020/5/5 3:43 下午
 */
@RestController
@Api(tags = "SwaggerController", description = "SwaggerController | 测试swagger")
@RequestMapping("api")
public class SwaggerController {


    @GetMapping("hello")
    @ApiOperation(value="hello 方法", notes="hello Swagger测试方法--hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("test1")
    @ApiOperation(value="test1 方法", notes="hello Swagger测试方法--test1")
    public String test1(){
        return "test1";
    }

    @GetMapping("test2")
    @ApiIgnore
    @ApiOperation(value="test2 方法", notes="hello Swagger测试方法-test2")
    public String test2(){
        return "test2";
    }
}
