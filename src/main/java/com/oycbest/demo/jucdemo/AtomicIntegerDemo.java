package com.oycbest.demo.jucdemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/7/8 10:48 下午
 */
public class AtomicIntegerDemo {
    static AtomicInteger atomicInteger = new AtomicInteger(10);

    public static void main(String[] args) {
        System.out.println("AtomicIntegerDemo");
        atomicInteger.compareAndSet(10,11);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.getAndDecrement());
        System.out.println(atomicInteger.get());


    }
}
