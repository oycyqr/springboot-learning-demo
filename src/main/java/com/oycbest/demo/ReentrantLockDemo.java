package com.oycbest.demo;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        System.out.println("ReentrantLockDemo……");
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        try {
            System.out.println("lock^^^^^^");
            System.out.println(lock.isFair());

            System.out.println(lock.getHoldCount());
        }finally {
            lock.unlock();
        }
        System.out.println(lock.getHoldCount());
        System.out.println(lock.isFair());
    }
}
