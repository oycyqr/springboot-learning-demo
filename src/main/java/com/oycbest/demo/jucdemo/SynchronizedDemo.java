package com.oycbest.demo.jucdemo;

/**
 * @Description: 读写锁 共享锁 互斥锁 独占锁
 * @Author oyc
 * @Date 2020/7/12 12:10 上午
 */
public class SynchronizedDemo {
    public static volatile int ticket_count = 5;

    public static void main(String[] args) {
        System.out.println("SynchronizedDemo");
        SynchronizedDemo syDemo = new SynchronizedDemo();
        for (int i = 0; i < 10; i++) {
            final int tempI = i;
            new Thread(() -> {
                syDemo.buyTicket(tempI);
            }, String.valueOf(i)).start();
        }
    }

    public synchronized void buyTicket(int tempI) {
        if (ticket_count > 0) {
            int ticketNum = ticket_count;
            System.out.println(tempI + "==== " + Thread.currentThread().getName() + " buy ticket [ " + ticketNum + " ]");
            ticket_count--;
            System.out.println(tempI + "====" + Thread.currentThread().getName() + " buy ticket [ " + ticketNum + " ] done");
        } else {
            System.out.println(Thread.currentThread().getName() + " ticket had sailed out");
        }

    }


}


