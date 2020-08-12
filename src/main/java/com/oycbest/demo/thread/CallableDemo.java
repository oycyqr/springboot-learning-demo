package com.oycbest.demo.thread;

import java.util.concurrent.Callable;

/**
 * @author: oyc
 * @date: 2020/8/7 10:28
 */
public class CallableDemo implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("CallableDemo run……");
        return "oyc";
    }
}
