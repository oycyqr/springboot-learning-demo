package com.oycbest.springbootlog4j2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/4/22 9:08 下午
 */
@RestController
@RequestMapping("log4j2")
public class Log4j2Controller {

    private static final org.slf4j.Logger log =  org.slf4j.LoggerFactory.getLogger(Log4j2Controller.class);


    @GetMapping("test1")
    public String test1() {
        log.debug("test1");
        log.info("test1");
        log.warn("test1");
        log.error("test1");
        return "test1";
    }
}
