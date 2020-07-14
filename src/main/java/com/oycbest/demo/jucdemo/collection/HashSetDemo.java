package com.oycbest.demo.jucdemo.collection;

import java.util.HashSet;

/**
 * @author: oyc
 * @date: 2020/7/14 15:28
 * 我们会遇到这样的几种情况:
 * 1 输出值为null;
 * 2 数组越界异常;
 * 3 某些线程没有输出值;
 */
public class HashSetDemo {

    static HashSet<String> hashSet = new HashSet<String>();

    public static void main(String[] args) {
        System.out.println("*********************HashSetDemo*********************");
        Thread[] threadArray = new Thread[1000];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new HsetThread();
            threadArray[i].start();

        }

        for (int i = 0; i < threadArray.length; i++) {
            try {
                threadArray[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

/**
 * 线程类，执行HashSet的add()增加方法
 */
class HsetThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 增加元素
        HashSetDemo.hashSet.add(Thread.currentThread().getName());
    }

}