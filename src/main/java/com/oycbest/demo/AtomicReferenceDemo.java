package com.oycbest.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicReferenceDemo {

    static AtomicReference<Integer> intA = new AtomicReference(100);
    static AtomicStampedReference<Integer> intA1 = new AtomicStampedReference(100,1);

    public static void main(String[] args) {
        System.out.println("AtomicReferenceDemo ………………");
        /*System.out.println("**** ABA 问题产生 ****");
        new Thread(() -> {
            try {
                System.out.println(String.format("t2 - A的初始值：%d",intA.get()));
                intA.compareAndSet(100,101);
                System.out.println(String.format("A的经过t1初次修改之后的值：%d",intA.get()));
                intA.compareAndSet(101,100);
                System.out.println(String.format("A的经过t1二次修改之后的值：%d",intA.get()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1"
        ).start();


        new Thread(() -> {
            try {
                System.out.println(String.format("t2 - A的初始值：%d",intA.get()));
                TimeUnit.MILLISECONDS.sleep(2);
                boolean compareAndSetResult = intA.compareAndSet(100, 1000);
                System.out.println(String.format("t2修改是否成功：%s",compareAndSetResult));
                System.out.println(String.format("A的经过t2初次修改之后的值：%d",intA.get()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2"
        ).start();*/


        System.out.println("**** ABA 问题解决 ****");
        new Thread(() -> {
            try {
                System.out.println(String.format("t2 - A的初始值：%d",intA1.getReference().intValue()));
                System.out.println(String.format("intA1当前版本：%d",intA1.getStamp()));

                TimeUnit.MILLISECONDS.sleep(1);

                intA1.compareAndSet(100,101,intA1.getStamp(),intA1.getStamp()+1);
                System.out.println(String.format("intA1当前版本：%d",intA1.getStamp()));
                System.out.println(String.format("A的经过t1初次修改之后的值：%d",intA1.getReference().intValue()));

                intA1.compareAndSet(101,100,intA1.getStamp(),intA1.getStamp()+1);
                System.out.println(String.format("intA1当前版本：%d",intA1.getStamp()));
                System.out.println(String.format("A的经过t1二次修改之后的值：%d",intA1.getReference().intValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t3"
        ).start();


        new Thread(() -> {
            try {
                int intA1Stamp = intA1.getStamp();
                System.out.println(String.format("t4 - A的初始值：%d",intA1.getReference().intValue()));
                System.out.println(String.format("intA1当前版本：%d",intA1Stamp));

                TimeUnit.MILLISECONDS.sleep(3);
                System.out.println(String.format("intA1当前版本：%d",intA1.getStamp()));

                boolean compareAndSetResult = intA1.compareAndSet(100, 1000,intA1Stamp,intA1Stamp+1);
                System.out.println(String.format("t4修改是否成功：%s",compareAndSetResult));
                System.out.println(String.format("A的经过t4初次修改之后的值：%d",intA1.getReference().intValue()));
                System.out.println(String.format("intA1当前版本：%d",intA1.getStamp()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t4"
        ).start();

    }
}
