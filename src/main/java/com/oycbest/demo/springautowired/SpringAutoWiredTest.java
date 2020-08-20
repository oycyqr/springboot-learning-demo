package com.oycbest.demo.springautowired;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: oyc
 * @date: 2020/8/20 14:29
 * AutoWired 测试
 *
 */
@Configuration
@ComponentScan("com.oycbest.demo.springautowired")
public class SpringAutoWiredTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAutoWiredTest.class);
        System.out.println("容器创建完成");
        applicationContext.getBean("user");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("************************* beanDefinitionName :" + beanDefinitionName);
            System.out.println("************************* beanDefinitionName :" + applicationContext.getBean(beanDefinitionName).toString());
        }
        applicationContext.close();
    }
}
