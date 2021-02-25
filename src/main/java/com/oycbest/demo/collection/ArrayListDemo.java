package com.oycbest.demo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: oyc
 * @date: 2020/7/14 15:28
 * 我们会遇到这样的几种情况:
 * <p>
 * 1 输出值为null;
 * 2 数组越界异常;
 * 3 某些线程没有输出值;
 */
public class ArrayListDemo {
    // static ArrayList<String> arrayList = new ArrayList<String>();
    static CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<String>();

    public static void main(String[] args) {
        System.out.println("*********************ArrayListDemo*********************");
        new ArrayListDemo().test1();
    }

    public void test1() {
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("a");
        Collections.sort(arrayList, (o1, o2) -> {
            // 返回值为int类型，大于0表示正序，小于0表示逆序
            return o1.compareTo(o2);
        });
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        String[] str = {"aa","bb","cc"};
        List<String> arrayList1 = Arrays.asList(str);

        try {
            for (String s : arrayList1) {
                if(s.equalsIgnoreCase("bb")){
                    arrayList1.remove(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> arrayList2 = new ArrayList(arrayList1);
        try {
            for (String s : arrayList2) {
                if(s.equalsIgnoreCase("bb")){
                    arrayList2.remove(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            System.out.println(arrayList2.get(i));
        }
    }

    public void test2() {
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
