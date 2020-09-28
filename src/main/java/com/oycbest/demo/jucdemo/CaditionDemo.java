package com.oycbest.demo.jucdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/7/18 11:07 下午
 */
public class CaditionDemo {
    private volatile int number = 1;
    private Lock lock = new ReentrantLock();

    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();


    public static void main(String[] args) {
        System.out.println("*************CaditionDemo*************");
        CaditionDemo caditionDemo = new CaditionDemo();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                caditionDemo.print5();
            }
        } , "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                caditionDemo.print10();
            }
        } , "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                caditionDemo.print15();
            }
        } , "C").start();
    }


    public void print5() {
        lock.lock();
        try {
            while (number != 1) {
                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            while (number != 2) {
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            while (number != 3) {
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
