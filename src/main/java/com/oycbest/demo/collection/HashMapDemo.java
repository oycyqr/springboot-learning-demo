package com.oycbest.demo.collection;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: oyc
 * @date: 2020/7/14 15:28
 */
public class HashMapDemo {
    static HashMap<String, String> stringHashMap = new HashMap<>();
    static ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("*********************HashMapDemo*********************");
        concurrentHashMap.put("2","two");
        concurrentHashMap.put("3","three"); // cas + synchronized
        concurrentHashMap.get("3");
    }
}
