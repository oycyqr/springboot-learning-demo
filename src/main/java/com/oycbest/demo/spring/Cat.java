package com.oycbest.demo.spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: oyc
 * @date: 2020/8/7 14:24
 */
@Component
public class Cat {

    public Cat() {
        System.out.println("Cat Constructor ……");
    }

    @PostConstruct
    public void initMethod(){
        System.out.println("Cat init method……");
    }

    @PreDestroy
    public void destroyMethod(){
        System.out.println("Cat destroy method……");
    }
}
