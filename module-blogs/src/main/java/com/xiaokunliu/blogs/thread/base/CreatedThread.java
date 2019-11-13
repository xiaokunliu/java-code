package com.xiaokunliu.blogs.thread.base;

import java.util.concurrent.FutureTask;

/**
 * date:2019/9/25 08:46
 * author:keithl
 */
public class CreatedThread {

    /**
     * 创建线程
     */
    public static void main(String[] args) throws Exception {

        // 创建线程的第一种方式
        // 继承线程的方式
        MyThread myThread = new MyThread(1, "mythread");

        // 实现runnable的方式
        Thread task = new Thread(new MyTask(100000, "mytask"));

        // 线程异步处理任务，带有返回结果
        FutureTask<String> futureTask = new FutureTask<>(new TaskResult());
        Thread callThread = new Thread(futureTask);

        myThread.start();
        task.start();
        callThread.start();

        // 阻塞等待获取结果
        System.out.println("callable result is " + futureTask.get());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("execute runnable run method ...");
            }
        }) {
            @Override
            public void run() {
                System.out.println("override thread run method ...");
            }
        }.start();

    }
}
