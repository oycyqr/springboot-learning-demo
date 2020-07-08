package com.oycbest.demo;

import org.springframework.util.Assert;

import java.util.Optional;

public class AssertDemo {
    public static void main(String[] args) {
        System.out.println("AssertDemo......");
        String str = null;
        Assert.notNull(str,"str 不能为空");
        Optional<String> a = Optional.ofNullable(str);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(null);
    }
}
