package com.oycbest.demo.thread;

/**
 * @ClassName: OyRunnable
 * @Description: OyRunnable
 * @Author oyc
 * @Date 2021/2/19 13:53
 * @Version 1.0
 */
public class OyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" OyRunnable run 。。。。。。");
    }

    public static void main(String[] args) {
        System.out.println("OyRunnable");
        OyRunnable oyRunnable = new OyRunnable();
        Thread thread = new Thread(oyRunnable,"我的runnable 线程");
        //thread.run();
        thread.start();
    }
}
