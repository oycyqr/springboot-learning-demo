package com.oycbest.demo.jucdemo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/7/8 10:48 下午
 */
public class AtomicReferanceDemo {

    static AtomicReference<Integer> a = new AtomicReference(10);
    public static void main(String[] args) {
        System.out.println("AtomicReferanceDemo");
        a.compareAndSet(10,11);
        System.out.println(a.get().intValue());
        a.compareAndSet(11,10);
        System.out.println(a.get().intValue());
        Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList a = new CopyOnWriteArrayList<>();
        a.add(1);
        Set s = new HashSet<>();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("","");

        ConcurrentHashMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<>();
        stringStringConcurrentHashMap.put("","");


    }
}
