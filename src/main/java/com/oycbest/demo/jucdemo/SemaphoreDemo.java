package com.oycbest.demo.jucdemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: oyc
 * @date: 2020/7/14 17:37
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 5个车位，10辆车
        Semaphore semaphore = new Semaphore(5, true);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("******* 剩余可用车位：" + (semaphore.availablePermits() + 1) + "  排队车数：" + (semaphore.getQueueLength() + 1));
                    System.out.println(Thread.currentThread().getName() + " 车进入停车");
                    TimeUnit.MILLISECONDS.sleep(200);
                    System.out.println(Thread.currentThread().getName() + " 车出场");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
