package com.oycbest.demo;

/**
 * @Author: oyc
 * @Date: 2020-05-27 9:58
 * @Description:
 */
public class MD5Demo {
	public static void main(String[] args) {
		String account = "oyc";
		String password = "123456";
		String salt = "12358";
		System.out.println(Md5Utils.hash(password));
		System.out.println(Md5Utils.hash(password+salt));
	}
}
