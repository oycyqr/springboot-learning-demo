package com.oycbest.demo.jucdemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: 读写锁 共享锁 互斥锁 独占锁
 * @Author oyc
 * @Date 2020/7/12 12:10 上午
 */
public class ReentrantReadWriteLockDemo {
    public static volatile int ticket_count = 50;
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    public static void main(String[] args) {
        System.out.println("ReentrantLockDemo");
        ReentrantReadWriteLockDemo syDemo = new ReentrantReadWriteLockDemo();
        for (int i = 0; i < 10; i++) {
            final int tempI = i;
            new Thread(() -> {
                syDemo.buyTicket(tempI);
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                syDemo.getTicket();
            }, String.valueOf(i)).start();
        }
    }

    public void buyTicket(int tempI) {
        writeLock.lock();
        try {
            if (ticket_count > 0) {
                int ticketNum = ticket_count;
                System.out.println(tempI + "==== " + Thread.currentThread().getName() + " buy ticket [ " + ticketNum + " ]");
                ticket_count--;
                // 休眠300毫秒，模拟拥堵情况
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(tempI + "====" + Thread.currentThread().getName() + " buy ticket [ " + ticketNum + " ] done");
            } else {
                System.out.println(Thread.currentThread().getName() + " ticket had sailed out");
            }
        } finally {
            writeLock.unlock();
        }
    }

    public void getTicket() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "start 开始读取当前剩余票数 ");

            // 休眠300毫秒，模拟拥堵情况
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 当前剩余票数 ： " + ticket_count + " 张 ");
        } finally {
            readLock.unlock();
        }
    }


}


