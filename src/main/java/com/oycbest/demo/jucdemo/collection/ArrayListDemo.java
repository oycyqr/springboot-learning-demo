package com.oycbest.demo.jucdemo.collection;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: oyc
 * @date: 2020/7/14 15:28
 * 我们会遇到这样的几种情况:
 *
 * 1 输出值为null;
 * 2 数组越界异常;
 * 3 某些线程没有输出值;
 */
public class ArrayListDemo {
    // static ArrayList<String> arrayList = new ArrayList<String>();
    static CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<String>();

    public static void main(String[] args) {
        System.out.println("*********************ArrayListDemo*********************");
        Thread[] threadArray = new Thread[1000];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new ArrayListThread();
            threadArray[i].start();

        }

        for (int i = 0; i < threadArray.length; i++) {
            try {
                threadArray[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == null) {
                System.out.println(arrayList.get(i));
            }
        }
    }
}

/**
 * 线程类，执行arrayList的add()增加方法
 */
class ArrayListThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 增加元素
        ArrayListDemo.arrayList.add(Thread.currentThread().getName());
    }

}