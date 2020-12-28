package com.oycbest.demo.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @ClassName List
 * @Description TODO
 * @Author oyc
 * @Date 2020/12/14 11:52
 * @Version
 */
public class ListDemo {
    public static void main(String[] args) {
        ListDemo listDemo = new ListDemo();
        System.out.println("list******");
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("3");
        list.add("4");
        list.add("2");
        list.forEach(s -> System.out.print(s + " "));
        Collections.sort(list);
        System.out.println("\nafter sort:");
        list.forEach(s -> System.out.print(s + " "));
        listDemo.add(list);
        System.out.println("\nafter add:");
        list.forEach(s -> System.out.print(s + " "));

        String str = "str";
        System.out.println("\nstr1:"+str);
        listDemo.changeStr(str);
        System.out.println("\nstr2:"+str);

        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"value-1");
        hashMap.put(2,"value-2");
        hashMap.put(3,"value-3");
        hashMap.put(4,"value-4");
        hashMap.put(5,"value-5");
        hashMap.put(6,"value-6");
        //Map.Entry<Integer,String>
        System.out.println("\nmap:");
        hashMap.entrySet().stream().forEach(map -> System.out.println(map.getKey()+"-----"+map.getValue()));
        hashMap.entrySet().stream().forEach(map -> {
            if(map.getKey().equals(4)){
               // hashMap.remove(map.getKey()); java.util.ConcurrentModificationException
            }
        });
        Iterator<Integer> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if(next.equals(4)){
                System.out.println("remove*** "+"key："+ next + " value:"+hashMap.get(next));
                iterator.remove();
                continue;
            }
            System.out.println("key："+ next + " value:"+hashMap.get(next));
        }
        System.out.println("\nmap1:");
        hashMap.entrySet().stream().forEach(map -> System.out.println(map.getKey()+"-----"+map.getValue()));
    }

    private void add(ArrayList<String> list) {
        list.add("5");
        list.add("6");
    }

    private void changeStr(String str) {
        str = "new str";
    }


}