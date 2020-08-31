package com.oycbest.demo.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @author: oyc
 * @date: 2020/8/31 9:55
 */
@Component
public class MainMethod {

    public int div(int i, int j) throws Exception {
        System.out.println("1=" + i);
        System.out.println("j=" + j);
        int result = i / j;
        System.out.println("result=" + result);
        return result;
    }
}
