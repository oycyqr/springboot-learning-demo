package com.oycbest.demo.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/8/31 10:12 下午
 */
@Component
@Aspect
public class PointCutConfiguration {

    Logger logger = LoggerFactory.getLogger(PointCutConfiguration.class);

    @Pointcut("execution(public * com.oycbest.demo.spring.aop.MainMethod.*(..))")
    private void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
        System.out.println("doBefore *********");
        logger.info("doBefore *********");
    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        logger.info("doAfter *********");
    }

    @AfterReturning(value = "pointCut()", returning = "retVal")
    public void doAfterReturning(JoinPoint joinPoint, Object retVal) {
        logger.info("结果为:{}",retVal.toString());
        logger.info("doAfterReturning *********");
    }

    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void doAfterThrowing(JoinPoint joinPoint,
                                Throwable ex) {
        logger.info(ex.getMessage());
        //ex.printStackTrace();
        logger.info("doAfterThrowing *********");
    }


}
