package com.oycbest.demo.jucdemo.collection;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: oyc
 * @date: 2020/7/14 15:28
 */
public class ArrayListDemo1 {
    public static void main(String[] args) {
        System.out.println("*********************ArrayListDemo1*********************");
        new ArrayListDemo1().test1();
    }

    public void test1() {
        ArrayList<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(4);
        list2.add(5);
        list2.add(6);
        System.out.println("list1.toString:" + list1.toString() + "list1.size:" + list1.size());
        System.out.println("list2.toString:" + list2.toString() + "list2.size:" + list2.size());
        list1.addAll(list2);
        System.out.println("list1.toString:" + list1.toString() + "list1.size:" + list1.size());
        System.out.println("list2.toString:" + list2.toString() + "list2.size:" + list2.size());

        Collections.copy(list1, list2);

        System.out.println("list1.toString:" + list1.toString() + "list1.size:" + list1.size());
        System.out.println("list2.toString:" + list2.toString() + "list2.size:" + list2.size());

    }

}