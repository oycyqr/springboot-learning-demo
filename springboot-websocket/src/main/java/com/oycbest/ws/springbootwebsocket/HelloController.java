package com.oycbest.ws.springbootwebsocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: oyc
 * @date: 2020/7/21 9:53
 */
@Controller
@RequestMapping("hello")
public class HelloController {
    @GetMapping
    public String hello(){
        return "index";
    }
}
