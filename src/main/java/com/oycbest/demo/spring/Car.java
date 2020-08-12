package com.oycbest.demo.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: oyc
 * @date: 2020/8/7 14:24
 */
@Component
public class Car implements InitializingBean, DisposableBean {

    public Car() {
        System.out.println("Car Constructor 。。。。。。");
    }
    @PostConstruct
    public void initMethod(){
        System.out.println("Car init method 。。。。。。");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Car afterPropertiesSet 。。。。。。");
    }

    @PreDestroy
    public void destroyMethod(){
        System.out.println("Car destroy method 。。。。。。");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Car destroy 。。。。。。");
    }
}
