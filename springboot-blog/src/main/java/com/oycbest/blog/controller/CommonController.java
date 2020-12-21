package com.oycbest.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/12/21 10:48 下午
 */
@RestController
public class CommonController {

    @GetMapping({"", "/welcome"})
    public String welcome() {
        return "welcome";
    }

    @GetMapping("admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("customer")
    public String customer() {
        return "customer";
    }
}
