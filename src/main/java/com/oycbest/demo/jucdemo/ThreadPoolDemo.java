package com.oycbest.demo.jucdemo;

import java.util.concurrent.*;

/**
 * @Author: oyc
 * @Date: 2020-06-11 9:41
 * @Description: 线程池demo
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        int taskNum = 200;
        // 一池五线程
        ExecutorService threadPool1 = Executors.newFixedThreadPool(10);
        // 一池一线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
        ExecutorService threadPool3 = Executors.newScheduledThreadPool(5);
        // 一池N线程
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < taskNum; i++) {
            threadPool1.submit(() -> {
                System.out.println("threadPool1 demo:" + Thread.currentThread().getName());
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        new ThreadPoolExecutor(1, 3,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(5));
        //ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 3,
                1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 10; i++) {
            //singleThreadPool.execute(()-> System.out.println("demo2:"+Thread.currentThread().getName()));
        }
        //singleThreadPool.shutdown();



        ExecutorService executor = new ThreadPoolExecutor(
                2, 5, 5, TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        Future<?> submit = executor.submit(() -> System.out.println(123));

        for (int i = 0; i < taskNum; i++) {
            executor.submit(() -> {
                System.out.println("executor demo:" + Thread.currentThread().getName());
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        System.out.println(submit.isDone());
        executor.shutdown();
        System.out.println(submit.isDone());
    }
}
