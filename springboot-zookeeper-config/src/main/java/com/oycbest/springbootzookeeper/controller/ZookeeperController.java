package com.oycbest.springbootzookeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/10/29 9:25 下午
 */
@RestController
@RequestMapping("zk")
public class ZookeeperController {

    @Autowired
    private Environment environment;

    @GetMapping
    public Object zk(){
        environment.getProperty("database");
        return null;
    }
}
