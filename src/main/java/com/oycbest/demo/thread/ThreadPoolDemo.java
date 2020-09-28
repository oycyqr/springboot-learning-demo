package com.oycbest.demo.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/9/3 9:50 下午
 */
public class ThreadPoolDemo {

    public boolean flag = false;
    public volatile  boolean volatileFlag = false;
    AtomicBoolean atomicBoolean = new AtomicBoolean(false);



    public static void main(String[] args) {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 0,
                TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(6), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                        //取反操作
                        threadPoolDemo.flag = !threadPoolDemo.flag;
                        threadPoolDemo.volatileFlag = !threadPoolDemo.volatileFlag;
                        //输出结果
                        System.out.println(Thread.currentThread().getName() + "  **** start ****   volatileFlag：" +
                                threadPoolDemo.volatileFlag + "   --   flag：" + threadPoolDemo.flag +
                                " " + threadPoolDemo.atomicBoolean.compareAndSet(threadPoolDemo.atomicBoolean.get(),!threadPoolDemo.atomicBoolean.get()));
                        try {
                            //TimeUnit.MILLISECONDS.sleep(3000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
            );
        }

    }
}
