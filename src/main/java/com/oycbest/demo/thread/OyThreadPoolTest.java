package com.oycbest.demo.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @ClassName: OyThreadPoolTest
 * @Description: OyThreadPoolTest
 * @Author oyc
 * @Date 2021/2/19 14:21
 * @Version 1.0
 */
public class OyThreadPoolTest {
    public static void main(String[] args) {
        System.out.println("OyThreadPoolTest");
    }

    @Test
    public void test1() {
        System.out.println("OyThreadPoolTest1 。。。。。。 ");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("executorService run");
            }
        });

        executorService.execute(() -> {
            System.out.println("executorService run······");
        });
    }

    @Test
    public void test2() {
        System.out.println("OyThreadPoolTest2 。。。。。。 ");
        // 等待队列
        LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(7);
        // 拒绝策略
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        // 线程工厂
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 5L, TimeUnit.MILLISECONDS,
                blockingQueue, threadFactory, handler);

        System.out.println("threadPoolExecutor.getCorePoolSize() = " + executor.getCorePoolSize());
        System.out.println("threadPoolExecutor.getPoolSize() = " + executor.getPoolSize());
        System.out.println("threadPoolExecutor.getQueue() = " + executor.getQueue());

        //往线程池中循环提交线程
        for (int i = 0; i < 6; i++) {
            //开启线程
            executor.execute(() -> {
                        //输出结果
                        System.out.println(Thread.currentThread().getName() + "  **** start ****   ");
                        try {
                            TimeUnit.MILLISECONDS.sleep(3000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
            );
            //获取线程池中线程的相应参数
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size() + "，已执行完的任务数目：" + executor.getCompletedTaskCount());
        }

        CountDownLatch latch = new CountDownLatch(4);
        //往线程池中循环提交线程
        for (int i = 0; i < 6; i++) {
            //开启线程
            executor.submit(() -> {
                        //输出结果
                        System.out.println(Thread.currentThread().getName() + "  **** start ****   ");
                        try {
                            TimeUnit.MILLISECONDS.sleep(3000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        latch.countDown();
                    }
            );
            //获取线程池中线程的相应参数
            System.out.println("2线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size() + "，已执行完的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.getQueue().forEach(s-> System.out.println(s));
        try {
            latch.await();
            System.out.println("end 线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" + executor.getQueue().size() + "，已执行完的任务数目：" + executor.getCompletedTaskCount());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
