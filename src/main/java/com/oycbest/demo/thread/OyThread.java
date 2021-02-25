package com.oycbest.demo.thread;

/**
 * @ClassName: OyThread
 * @Description: OyThread
 * @Author oyc
 * @Date 2021/2/19 13:50
 * @Version 1.0
 */
public class OyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " OyThread run 。。。。。。");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("OyThread");
        Thread oyThread = new OyThread();
        oyThread.setName("我的线程0");
        System.out.println("oyThread.getId() = " + oyThread.getId());
        //oyThread.run();
        oyThread.start();
    }
}
