package com.xiaokunliu.blogs.thread.base;

/**
 * date:2019/9/25 08:51
 * author:keithl
 */
public class MyTask implements Runnable {

    private int count;

    public MyTask(int count, String threadName) {
        this.count = count;
        Thread.currentThread().setName(threadName);
    }

    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            count--;
            System.out.println("thread id is " + Thread.currentThread().getId() + ",name: " + Thread.currentThread().getName() + "count：" + count);
        }
    }
}
