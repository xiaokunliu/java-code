package com.books.concurrency_en.thread_management.localvar;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable{

    // 为每个线程分配一个本地变量,并进行初始化分配为每一个日期对象
    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n",Thread.currentThread().getId(),startDate.get());
        try {
            TimeUnit.SECONDS.sleep( (int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",Thread.currentThread().getId(),startDate.get());
    }
}
