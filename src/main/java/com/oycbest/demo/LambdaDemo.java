package com.oycbest.demo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: oyc
 * @Date: 2020-05-08 10:37
 * @Description:
 */
public class LambdaDemo {
	public static void main(String[] args) {
		String[] strArr = {"宋江", "卢俊义", "吴用", "公孙胜", "关胜", "林冲", "秦明", "呼延灼", "武松", "李逵", "史进", "穆弘", "雷横", "李俊", "阮小二", "张横", "阮小五", "张顺", "宋清", "乐和", "龚旺", "丁得孙", "穆春", "曹正", "宋万"};
		List<String> userList = Arrays.asList(strArr);
		List<String> userList1;

		// 以前的循环方式
		System.out.print("以前的循环方式:");
		for (String user : userList) {
			System.out.print(user + "; ");
		}

		// 使用 lambda 表达式以及函数操作(functional operation)
		System.out.print("\nlambda 表达式以及函数:");
		userList.forEach((user) -> System.out.print(user + "; "));

		// 在 Java 8 中使用双冒号操作符(double colon operator)
		System.out.print("\nJava 8 中使用双冒号操作符:");
		userList.forEach(System.out::print);

		// 在 Java 8 中使用双冒号操作符(double colon operator)
		userList1 = userList.stream().map(s -> s + "; ").collect(Collectors.toList());
		System.out.print("\nJava 8 中使用双冒号操作符:");
		userList1.forEach(System.out::print);
		System.out.println();
		userList.stream().map(s -> s + "; ").forEach(System.out::print);

		System.out.print("\n最前面的3个英雄:");
		userList.stream()
				.limit(3)
				.forEach((u) -> System.out.printf("%s; ", u));

		System.out.print("\n最前面的3个姓宋的英雄:");
		userList.stream()
				.filter(s -> s.indexOf("宋") == 0)
				.limit(3)
				.forEach((u) -> System.out.printf("%s; ", u));

		System.out.print("\n最前面的5个 名字3位字的英雄:");
		userList.stream()
				.filter(s -> s.length() == 3)
				.limit(5)
				.forEach((u) -> System.out.printf("%s; ", u));

		System.out.print("\n名字2位字的英雄:");
		userList1 = userList.stream()
				.filter(s -> s.length() == 2).collect(Collectors.toList());
		userList1.stream().forEach(s -> System.out.print(s + "; "));


		ArrayList<Integer> integerList = new ArrayList() {{
			add(1);
			add(20);
			add(3);
			add(8);
			add(6);
		}};


		System.out.print("\n最大的数字,最小的数字:");
		Collections.max(integerList);
		int max = integerList.stream()
				.max((a, b) -> (a - b))
				.get();

		int min = integerList.stream()
				.max((a, b) -> (b - a))
				.get();
		System.out.print(max + "," + min);
		System.out.print(" max:" + integerList.stream().max((a, b) -> (a - b)).get());
		System.out.print(" max:" + Collections.max(integerList));
		System.out.print(" min:" + Collections.min(integerList));

		System.out.print("\n计算sum:");
		int sum = integerList
				.parallelStream()
				.mapToInt(p -> p)
				.sum();

		System.out.print(sum);

		//我们可以使用summaryStatistics方法获得stream 中元素的各种汇总数据。 接下来,我们可以访问这些方法,比如getMax, getMin, getSum或getAverage:
		//计算 count, min, max, sum, and average for numbers
		IntSummaryStatistics stats = integerList
				.stream()
				.mapToInt((x) -> x)
				.summaryStatistics();

		System.out.println("\nList中最大的数字 : " + stats.getMax());
		System.out.println("List中最小的数字 : " + stats.getMin());
		System.out.println("所有数字的总和   : " + stats.getSum());
		System.out.println("所有数字的平均值 : " + stats.getAverage());
	}
}
