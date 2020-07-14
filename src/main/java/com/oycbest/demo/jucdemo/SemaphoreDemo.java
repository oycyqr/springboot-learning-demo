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
        Semaphore semaphore = new Semaphore(1, true);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 车进入");
                    TimeUnit.MILLISECONDS.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " 车出场");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
