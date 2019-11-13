package com.xiaokunliu.blogs.thread.base;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * date:2019/9/25 12:19
 * author:keithl
 */
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {

        Thread dataSourceTask = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date() + " " + Thread.currentThread().getName() + " start execute data source task ....");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date() + " " + Thread.currentThread().getName() + " finish execute data source task ....");
            }
        });


        Thread networkTask = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date() + " " + Thread.currentThread().getName() + " start execute net work task ....");
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date() + " " + Thread.currentThread().getName() + " finish execute ney work task ....");
            }
        });

        // start two thread
        dataSourceTask.start();
        networkTask.start();


        dataSourceTask.join();
        networkTask.join();
        System.out.println(new Date() + " " + Thread.currentThread().getName() + " both datasource task and network task have finished");
    }
}
