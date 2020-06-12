package com.oycbest.demo;

import java.util.concurrent.*;

/**
 * @Author: oyc
 * @Date: 2020-06-11 9:41
 * @Description: 线程池demo
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		// 一池五线程
		ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
		// 一池一线程
		ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
		ExecutorService threadPool3 = Executors.newScheduledThreadPool(5);
		// 一池N线程
		ExecutorService threadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 6; i++) {
			//threadPool.execute(()-> System.out.println("demo1:"+Thread.currentThread().getName()));
		}
		//ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
		ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 3,
				1L, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
		for (int i = 0; i < 10; i++) {
			singleThreadPool.execute(()-> System.out.println("demo2:"+Thread.currentThread().getName()));
		}
		singleThreadPool.shutdown();
	}
}
