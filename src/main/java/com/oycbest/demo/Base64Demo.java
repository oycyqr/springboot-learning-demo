package com.oycbest.demo;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Author: oyc
 * @Date: 2020-05-27 9:34
 * @Description:
 */
public class Base64Demo {
	public static void main(String[] args) {
		String account = "oyc";
		String password = "123456";
		//编码
		String encode = Base64.getEncoder().encodeToString((account + password).getBytes(StandardCharsets.UTF_8));
		System.out.println(encode);

		//解码
		String decode = new String(Base64.getDecoder().decode(encode), StandardCharsets.UTF_8);
		System.out.println(decode.replace(account,""));
		System.out.println(decode);
	}
}
