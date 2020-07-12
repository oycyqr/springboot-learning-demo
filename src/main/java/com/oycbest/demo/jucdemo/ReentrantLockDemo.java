package com.oycbest.demo.jucdemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 读写锁 共享锁 互斥锁 独占锁
 * @Author oyc
 * @Date 2020/7/12 12:10 上午
 */
public class ReentrantLockDemo {
    public static volatile int ticket_count = 5;
    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println("ReentrantLockDemo");
        ReentrantLockDemo syDemo = new ReentrantLockDemo();
        for (int i = 0; i < 10; i++) {
            final int tempI = i;
            new Thread(() -> {
                syDemo.buyTicket(tempI);
            }, String.valueOf(i)).start();
        }
    }

    public void buyTicket(int tempI) {
        lock.lock();
        try {
            if (ticket_count > 0) {
                int ticketNum = ticket_count;
                System.out.println(tempI + "==== " + Thread.currentThread().getName() + " buy ticket [ " + ticketNum + " ]");
                ticket_count--;
                System.out.println(tempI + "====" + Thread.currentThread().getName() + " buy ticket [ " + ticketNum + " ] done");
            } else {
                System.out.println(Thread.currentThread().getName() + " ticket had sailed out");
            }
        } finally {
            lock.unlock();
        }

    }


}


