package com.books.concurrency_en.thread_management.localvar;

import java.util.concurrent.TimeUnit;

public class UsingLocalVariable {

    public static void main(String[] args) {
//        unsafeForTask();  // 线程由于数据共享,存在线程安全问题,导致前后数据不一致
        safeForTask();    // 线程使用本地线程变量报错数据,保证每一个线程都有自己的变量信息,不会被篡改,数据前后一致
    }

    private static void unsafeForTask() {
        UnsafeTask task=new UnsafeTask();
        for (int i=0; i<10; i++){
            Thread thread=new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void safeForTask() {
        SafeTask task=new SafeTask();
        for (int i=0; i<10; i++){
            Thread thread=new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
