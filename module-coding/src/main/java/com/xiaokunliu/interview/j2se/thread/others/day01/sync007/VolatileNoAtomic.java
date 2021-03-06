package com.xiaokunliu.interview.j2se.thread.others.day01.sync007;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile关键字不具备synchronized关键字的原子性（同步）
 * 用这个关键字来修饰的变量可以在多个线程中是可见性
 *
 * @author alienware
 */
public class VolatileNoAtomic extends Thread {
    //private static volatile int count;
    private static AtomicInteger count = new AtomicInteger(0);

    private static void addCount() {
        for (int i = 0; i < 1000; i++) {
            //count++ ;
            count.incrementAndGet();
        }
        System.out.println(count);
    }

    public static void main(String[] args) {

        VolatileNoAtomic[] arr = new VolatileNoAtomic[100];
        for (int i = 0; i < 10; i++) {
            arr[i] = new VolatileNoAtomic();
        }

        for (int i = 0; i < 10; i++) {
            arr[i].start();
        }
    }

    public void run() {
        addCount();
    }


}
