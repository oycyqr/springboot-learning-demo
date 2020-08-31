package com.oycbest.demo.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: oyc
 * @date: 2020/8/31 9:55
 */
@Aspect
@Component
public class OycAspect {

    @Pointcut("execution(public * com.oycbest.demo.spring.aop.MainMethod.div(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(final JoinPoint joinPoint) {
        for (Object arg : joinPoint.getArgs()) {
            System.out.println("参数：" + arg);
        }
        System.out.println("before******：" + joinPoint.getArgs().length);
        Object args[] = joinPoint.getArgs();
        MethodSignature sig = (MethodSignature) joinPoint.getSignature();
        Method method = sig.getMethod();
        if (null != method.getDeclaringClass().getName() && null != method.getName() && null != args && args.length > 0) {
            System.out.println(method.getDeclaringClass().getName() + " . " + method.getName() + " : 请求参数：" );
            for (Object arg : joinPoint.getArgs()) {
                System.out.print(arg + " ,");
            }
        }
    }

    @After("pointCut()")
    public void doAfter(final JoinPoint joinPoint) {
        System.out.println("after******");
    }

    @AfterReturning(value = "pointCut()", returning = "rvt")
    public void doAfterReturning(final JoinPoint joinPoint, Object rvt) {
        System.out.println("afterReturning******" + joinPoint.getTarget());

        MethodSignature sig1 = (MethodSignature) joinPoint.getSignature();
        Method method1 = sig1.getMethod();
        if (null != rvt && null != method1.getDeclaringClass()) {
            try {
                System.out.println(method1.getDeclaringClass().getName() + "." + method1.getName() + " 返回数据：" + rvt);
            } catch (Exception e) {
            }
        }

    }

    @AfterThrowing("pointCut()")
    public void doAfterThrowing(final JoinPoint joinPoint) {
        System.out.println("afterThrowing******");
    }

   /* @Around("pointCut()")
    public void doAround(final JoinPoint joinPoint) {
        System.out.println("around******");
    }*/

}
