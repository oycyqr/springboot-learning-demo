package com.oycbest.demo.jucdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/7/12 11:10 下午
 */
public class CountDownLatchDemo {
    public static volatile int ticket_count = 8;

    public static void main(String[] args) {
        System.out.println("CountDownLatchDemo");
        CountDownLatch countDownLatch = new CountDownLatch(ticket_count);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println("票已卖出，剩余票数：" + --ticket_count);
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("票已卖完………………");
    }
}
