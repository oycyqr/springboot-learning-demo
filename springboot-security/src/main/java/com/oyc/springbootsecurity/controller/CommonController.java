package com.oyc.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: CommonController
 * @Description: CommonController
 * @Author oyc
 * @Date 2020/12/21 11:52
 * @Version 1.0
 */
@Controller
public class CommonController {

    @GetMapping(value = {"","welcome"})
    @ResponseBody
    public String welcome(){
        return "Welcome!!!";
    }

    @GetMapping(value = {"hello"})
    @ResponseBody
    public String hello(){
        return "hello!!!";
    }

    @GetMapping(value = {"admin"})
    @ResponseBody
    public String admin(){
        return "admin!!!";
    }
}