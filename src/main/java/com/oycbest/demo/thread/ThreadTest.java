package com.oycbest.demo.thread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: oyc
 * @date: 2020/8/7 10:29
 */
public class ThreadTest {
    public static void main(String[] args) {
    }

    @Test
    public void test1() {
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread1 = new Thread(runnableDemo);
        thread1.start();
    }

    @Test
    public void test2() {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
    }

    @Test
    public void test3() {
        FutureTask futureTask = new FutureTask(new CallableDemo());
        try {
            Thread thread = new Thread(futureTask);
            thread.start();
            Object o = futureTask.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
