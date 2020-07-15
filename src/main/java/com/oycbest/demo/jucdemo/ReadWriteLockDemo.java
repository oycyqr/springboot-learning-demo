package com.oycbest.demo.jucdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: 读写锁 共享锁 互斥锁 独占锁
 * @Author oyc
 * @Date 2020/7/12 12:10 上午
 */


public class ReadWriteLockDemo {
    public static void main(String[] args) {
        System.out.println("ReadWriteLockDemo");
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                new MyCache().put(String.valueOf(finalI), finalI + "value");
            }, String.valueOf(i)).start();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int j = 0; j < 5; j++) {
            int finalI = j;
            new Thread(() -> {
                new MyCache().get(String.valueOf(finalI));
            }, String.valueOf(j)).start();

        }
    }
}


class MyCache {
    public static volatile Map<String, Object> cacheMap = new HashMap<String, Object>();

    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();


    public synchronized void put(String key, Object value) {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "------ 开始写入********");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cacheMap.put(key, value);
            System.out.println(Thread.currentThread().getName() + "------ 写入完成: " + value);
        } finally {
            writeLock.unlock();
        }
    }


    public Object get(String key) {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "------ 开始读取");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = cacheMap.get(key);
            System.out.println(Thread.currentThread().getName() + "------ 读取完成: " + result);
            return result;
        } finally {
            readLock.unlock();
        }
    }

}
