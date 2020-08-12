package com.oycbest.demo.spring;

/**
 * @author: oyc
 * @date: 2020/8/7 14:24
 */
public class Pig {

    private String name;
    private int age;

    public Pig() {
        System.out.println("Pig Constructor 。。。。。。");
    }

    public Pig(String name,Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("Pig Constructor 。。。。。。");
    }


    public void initMethod() throws Exception {
        System.out.println("Pig initMethod 。。。。。。");
    }

    public void destroyMethod() throws Exception {
        System.out.println("Pig destroyMethod 。。。。。。");
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
