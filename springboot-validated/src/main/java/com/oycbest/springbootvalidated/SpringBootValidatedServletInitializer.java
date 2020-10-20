package com.oycbest.springbootvalidated;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Description: 发布到tomcat需要添加一个servlet的初始化类
 * @Author oyc
 * @Date 2020/4/23 12:40 下午
 */
public class SpringBootValidatedServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        //Application类，这里一定要指向原先用main方法执行的Application启动类
        return application.sources(SpringbootValidatedApplication.class);
    }
}