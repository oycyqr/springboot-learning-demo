package com.oycbest.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: oyc
 * @Date: 2020-06-02 9:10
 * @Description:
 */
public class JConsoleTest {
	public  byte[] b1 = new byte[1000 * 1024 *1024*1024];

	public static void main(String[] args) {
		System.out.println("start...");
		fill(10000);
	}

	private static void fill(int n) {
		List jlist = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			jlist.add(new JConsoleTest());
		}
	}
}
