package com.oycbest.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: OyCallable
 * @Description: OyCallable
 * @Author oyc
 * @Date 2021/2/19 13:57
 * @Version 1.0
 */
public class OyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " OyCallable run 。。。。。。" );
        return "OyCallable call 结果";
    }


    public static void main(String[] args) {
        System.out.println("OyCallable");
        OyCallable oyCallable = new OyCallable();
        FutureTask futureTask = new FutureTask<>(oyCallable);
        futureTask.run();
        try {
            System.out.println("futureTask.get() = " + futureTask.get());
            System.out.println("futureTask.isDone() = " + futureTask.isDone());
            System.out.println("futureTask.isCancelled() = " + futureTask.isCancelled());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
