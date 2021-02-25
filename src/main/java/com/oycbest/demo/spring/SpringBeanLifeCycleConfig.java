package com.oycbest.demo.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: oyc
 * @date: 2020/8/7 14:29
 * bean 生命周期测试
 *
 */
@Configuration
@ComponentScan("com.oycbest.demo.spring")
public class SpringBeanLifeCycleConfig {

    //@Scope("prototype")
//    @Bean(name = "pig001",initMethod = "initMethod",destroyMethod = "destroyMethod")
//    public Pig pig0001(){
//       return new Pig("天蓬元帅",18);
//    }
}
