package com.oycbest.demo;

public class SynchronizedDemo {
    private volatile int value = 10;

    public int increamentAndGet(Boolean sync) {
        if (sync) {
            synchronized (this) {
                value = value-1;
                return value;
            }
        } else {
            value = value-1;
            return value;
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        synchronizedDemo.synchronizedTest(false);
    }

    public void synchronizedTest(Boolean sync) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        new Thread(() -> {
            while (value > 0) {
                System.out.println("用户" + Thread.currentThread().getName() + "买了第" + synchronizedDemo.increamentAndGet(sync) + "张票");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "张三").start();
        new Thread(() -> {
            while (value > 0) {
                System.out.println("用户" + Thread.currentThread().getName() + "买了第" + synchronizedDemo.increamentAndGet(sync) + "张票");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "李四").start();

        new Thread(() -> {
            while (value > 0) {
                System.out.println("用户" + Thread.currentThread().getName() + "买了第" + synchronizedDemo.increamentAndGet(sync) + "张票");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "王五").start();
    }
}
