package com.oycbest.demo.thread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: OyTest
 * @Description: OyTest
 * @Author oyc
 * @Date 2021/2/19 13:51
 * @Version 1.0
 */
public class OyTest {

    @Test
    public void testThread(){
        System.out.println("testThread");
        Thread oyThread = new OyThread();
        //oyThread.run();
        oyThread.start();
    }

    @Test
    public void testThread1(){
        System.out.println("testThread1");
        Thread oyThread1 = new OyThread();
        Thread oyThread2 = new OyThread();
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
        oyThread1.start();
        System.out.println("oyThread1.isAlive() = " + oyThread1.isAlive());
        System.out.println("oyThread1.getId() = " + oyThread1.getId());
        System.out.println("oyThread1.getName() = " + oyThread1.getName());
        System.out.println("oyThread1.getState() = " + oyThread1.getState());
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
        oyThread2.start();
        try {
            oyThread2.join();//等待线程2的结束
            System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testRunnable(){
        System.out.println("testRunnable");
        Runnable oyRunnable = new OyRunnable();
        Thread thread = new Thread(oyRunnable);
        //oyRunnable.run();
        thread.start();
    }

    @Test
    public void testCallable(){
        System.out.println("testCallable");
        OyCallable oyCallable = new OyCallable();

        FutureTask futureTask = new FutureTask<>(oyCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        Object o = null;
        try {
            o = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(o);

    }
}
