package com.oycbest.demo.jucdemo;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @ClassName: JucTest
 * @Description: JucTest
 * @Author oyc
 * @Date 2021/2/24 13:57
 * @Version 1.0
 */
public class JucTest {

    public static void main(String[] args) {
        System.out.println("JucTest args = " + args);
        new JucTest().semaphoreTest();
    }


    @Test
    public void CyclibarrerTest() {
        int num = 7;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(num, () -> {
            System.out.println("集齐7颗龙珠，可以召唤神龙");
        });

        for (int i = 0; i < num; i++) {
            new Thread(
                    () -> {
                        try {
                            System.out.println(Thread.currentThread().getName() + " = 收集龙珠");
                            cyclicBarrier.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
            ).start();
        }
    }

    @Test
    public void CountDownLatchTest() {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 同学离开");
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
            System.out.println("同学都离开了，可以锁门");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void semaphoreTest() {
        // 服务区停车场停车位数量
        Semaphore semaphore = new Semaphore(5, true);
        // 10 辆车需要进入
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 进入 ******* 剩余可用车位：" + semaphore.availablePermits() + "  排队车数：" + semaphore.getQueueLength());
                    TimeUnit.MILLISECONDS.sleep(1000);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + " 离开   ******* 剩余可用车位：" + semaphore.availablePermits() + "  排队车数：" + semaphore.getQueueLength());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i + " 号车")).start();
        }

    }

    @Test
    public void ThreadPoolTest() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 5,
                5, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(5));

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                synchronized (this) {
                    System.out.println();
                    System.out.println("threadPoolExecutor.getPoolSize() = " + threadPoolExecutor.getPoolSize());
                    System.out.println("threadPoolExecutor.getQueue().size() = " + threadPoolExecutor.getQueue().size());
                    System.out.println("threadPoolExecutor.getActiveCount() = " + threadPoolExecutor.getActiveCount());
                    System.out.println("Thread.currentThread().getId() = " + Thread.currentThread().getId() + "   Thread.currentThread().getName() = " + Thread.currentThread().getName());
                }
            });
        }
    }

}
