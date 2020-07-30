package com.oycbest.demo;

/**
 * @author: oyc
 * @date: 2020/7/30 15:34
 */
public class Person {
    private String name;
    private Integer age;

    public Person() {
    }
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 吃饭
     */
    public void eat() {
        System.out.println(this.getName() + "吃饭");
    }

    /**
     * 睡觉
     */
    public void sleep() {
        System.out.println(this.getName() + "睡觉");
    }

    /**
     * 唱歌
     */
    public void sing() {
        System.out.println(this.getName() + "唱歌");
    }
}
