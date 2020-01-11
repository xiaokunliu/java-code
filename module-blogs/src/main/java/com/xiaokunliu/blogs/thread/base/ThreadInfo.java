package com.xiaokunliu.blogs.thread.base;

/**
 * date:2020/1/6 19:40
 * author:keithl
 * desc: business desc etc.
 */
public class ThreadInfo extends Thread {

    public ThreadInfo(String name, int priority) {
        this.setName(name);
        this.setPriority(priority);
    }

    @Override
    public void run() {
        for (int index = 0; index < 100; index++) {
            // do something
        }
    }
}
