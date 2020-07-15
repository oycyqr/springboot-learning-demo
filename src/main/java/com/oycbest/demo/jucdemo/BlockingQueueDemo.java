package com.oycbest.demo.jucdemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: oyc
 * @date: 2020/7/15 9:09
 */
public class BlockingQueueDemo {
    private volatile static ArrayBlockingQueue arrayBlockingQueue1 = new ArrayBlockingQueue(3);
    private volatile static SynchronousQueue synchronousQueue1 = new SynchronousQueue();;

    public static void main(String[] args) {
        BlockingQueueDemo blockingQueueDemo = new BlockingQueueDemo();
        //blockingQueueDemo.test1();
        //blockingQueueDemo.test2();
        blockingQueueDemo.test3();
    }

    public void test3() {
        // 生产者
        new Thread(() -> {
            try {
                while (true){
                    int num = (int) (Math.random()*1000);
                    System.out.println(Thread.currentThread().getName() + " 生产:" + num);
                    BlockingQueueDemo.arrayBlockingQueue1.put(num);
                    TimeUnit.MILLISECONDS.sleep(5000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "providor").start();
        // 消费者
        new Thread(() -> {
            try {
                while (true){
                    System.out.println(Thread.currentThread().getName() + " 消费：" + BlockingQueueDemo.arrayBlockingQueue1.take());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "comsumer").start();
    }

    public void test2() {
        // 生产者
        new Thread(() -> {
            try {
                while (true){
                    int num = (int) (Math.random()*1000);
                    System.out.println(Thread.currentThread().getName() + "生产:" + num);
                    BlockingQueueDemo.synchronousQueue1.put(num);
                    TimeUnit.MILLISECONDS.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "providor").start();
        // 消费者
        new Thread(() -> {
            try {
                while (true){
                    System.out.println(Thread.currentThread().getName() + " 消费：" + BlockingQueueDemo.synchronousQueue1.take());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "comsumer").start();
    }

    public void test1() {
        System.out.println("BlockingQueueDemo");
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
        System.out.println("add ***********");
        // 超出抛异常 IllegalStateException: Queue full
        try {
            arrayBlockingQueue.add("1");
            arrayBlockingQueue.add("2");
            arrayBlockingQueue.add("3");
            arrayBlockingQueue.add("4");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        arrayBlockingQueue.stream().forEach(a -> System.out.println(a.toString()));
        //超出 false
        System.out.println("offer ***********");
        try {
            System.out.println(arrayBlockingQueue.offer("4"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        arrayBlockingQueue.stream().forEach(a -> System.out.println(a.toString()));
        //超出 阻塞
        System.out.println("put ***********");
        try {
            // 出队，不然会因为队列长度不足而阻塞
            //System.out.println("take:" + arrayBlockingQueue.take());
            arrayBlockingQueue.put("4");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        arrayBlockingQueue.stream().forEach(a -> System.out.println(a.toString()));

        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque<>();
        SynchronousQueue synchronousQueue = new SynchronousQueue();
    }
}
