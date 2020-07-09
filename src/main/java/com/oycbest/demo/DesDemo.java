package com.oycbest.demo;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.DES;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/6/16 8:02 下午
 */
public class DesDemo {
    public static void main(String[] args) {
        System.out.println("Des demo");

        System.out.println( encode("123456","asdfghjk"));
        System.out.println( decode(encode("123456","asdfghjk"),"asdfghjk"));
        System.out.println( decode("83b2455cbbdfc4b5","asdfghjk"));

        //System.out.println( encode("123456"));
        System.out.println( decode("83b2455cbbdfc4b5"));
    }

    private static final String KEY = "asdfghjk";

    /**
     * 解密
     * @param str
     * @param key
     * @return
     */
    public static String decode(String str,String key) {
        //构建
        DES des = SecureUtil.des(key.getBytes());
        return des.decryptStr(str);
    }

    /**
     * 加密
     * @param str
     * @param key
     * @return
     */
    public static String encode(String str,String key) {
        //构建
        DES des = SecureUtil.des(key.getBytes());
        //加密为16进制，解密为原字符串
        return des.encryptHex(str);
    }

    /**
     * 解密
     * @param str
     * @return
     */
    public static String decode(String str) {
        return decode(str,KEY);
    }

    /**
     * 加密
     * @param str
     * @return
     */
    public static String encode(String str) {
        return decode(str,KEY);
    }
}
