package com.xiaokunliu.blogs.thread.base;

/**
 * date:2019/9/25 08:47
 * author:keithl
 */
public class MyThread extends Thread {

    // 创建线程的方式 -- 继承线程
    private int count;
//    private String threadName;

    public MyThread(int count, String threadName) {
        this.count = count;
        this.setName(threadName);
//        this.getState();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            count++;
            if (i == 50) {
                Thread.currentThread().stop();
//                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread() + "name: " + Thread.currentThread().getName() + "execute count is " + count);
        }
    }
}
