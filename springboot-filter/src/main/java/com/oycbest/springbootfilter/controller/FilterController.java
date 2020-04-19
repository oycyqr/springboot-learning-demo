package com.oycbest.springbootfilter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/4/19 9:57 下午
 */
@RestController
@RequestMapping("filter")
public class FilterController {

    @GetMapping
    public String filterDemo(){
        return "This is Filter demo Controller";
    }
}
