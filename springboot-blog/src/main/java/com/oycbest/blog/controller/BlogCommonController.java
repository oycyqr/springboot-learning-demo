package com.oycbest.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: BlogAdminController
 * @Description: BlogAdminController
 * @Author oyc
 * @Date 2020/12/17 22:44
 * @Version 1.0
 */
@Controller
public class BlogCommonController {

    @RequestMapping("loginPage")
    public String login() {
        return "login";
    }

    @GetMapping
    @ResponseBody
    public String index() {
        return "Welcome to my blog";
    }
}