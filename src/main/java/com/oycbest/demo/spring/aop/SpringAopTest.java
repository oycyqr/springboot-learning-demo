package com.oycbest.demo.spring.aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: oyc
 * @date: 2020/8/31 9:54
 */
@ComponentScan("com.oycbest.demo.spring.aop")
@EnableAspectJAutoProxy
public class SpringAopTest {
    @Test
    public void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAopTest.class);
        System.out.println("容器创建完成");

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("************************* beanDefinitionName :" + beanDefinitionName);
        }
        MainMethod mainMethod = applicationContext.getBean(MainMethod.class);
        try {
            System.out.println(mainMethod.div(20,4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        applicationContext.close();
    }
}
