package com.oycbest.demo.spring.aop;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/8/31 10:11 下午
 */
@EnableAspectJAutoProxy
@ComponentScan("com.oycbest.demo.spring.aop")
public class AspectTest {

    Logger logger = LoggerFactory.getLogger(AspectTest.class);

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AspectTest.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            logger.info("bean:{}" , beanDefinitionName);
        }
        MainMethod bean = applicationContext.getBean(MainMethod.class);
        try {
            bean.div(10, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            bean.div(1, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
