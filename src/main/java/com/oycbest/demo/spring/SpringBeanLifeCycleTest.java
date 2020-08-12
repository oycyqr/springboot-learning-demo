package com.oycbest.demo.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
public class SpringBeanLifeCycleTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringBeanLifeCycleTest.class);
        System.out.println("容器创建完成");
        applicationContext.getBean("cat");
        Pig pig = (Pig) applicationContext.getBean("pig001");
        System.out.println(pig.toString());
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("************************* beanDefinitionName :" + beanDefinitionName);
        }

        applicationContext.close();
    }
}
