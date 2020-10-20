package com.oycbest.springbootvalidated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("hello")
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("test")
    public String test(HttpServletRequest request) {
        String key = request.getParameter("key");
        logger.warn("测试-test:" + key);
        return "test" + key;
    }
}
