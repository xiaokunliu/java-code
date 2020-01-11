package com.xiaokunliu.blogs.thread.base;

import java.util.HashMap;
import java.util.Map;

/**
 * date:2019/9/25 08:46
 * author:keithl
 */
public class CreatedThread {

    /**
     * 创建线程
     */
    public static void main(String[] args) {

        // 创建线程的第一种方式
        // 继承线程的方式
//        MyThread myThread = new MyThread(1, "mythread");
//
//        // 实现runnable的方式
//        Thread task = new Thread(new MyTask(100000, "mytask"));
//
//        // 线程异步处理任务，带有返回结果
//        FutureTask<String> futureTask = new FutureTask<>(new TaskResult());
//        Thread callThread = new Thread(futureTask);
//
//        myThread.start();
//        task.start();
//        callThread.start();
//
//        // 阻塞等待获取结果
//        System.out.println("callable result is " + futureTask.get());
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("execute runnable run method ...");
//            }
//        }) {
//            @Override
//            public void run() {
//                System.out.println("override thread run method ...");
//            }
//        }.start();


        // 显示线程的基础信息：Id/状态/名称/优先级
        Map<ThreadInfo, Thread.State> threadInfoStateMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            ThreadInfo threadInfo = null;
            if (i % 2 == 0) {
                threadInfo = new ThreadInfo("Thread-" + (i + 1), Thread.MAX_PRIORITY);
            } else {
                threadInfo = new ThreadInfo("Thread-" + (i + 1), Thread.MIN_PRIORITY);
            }
            // 输出此时线程的信息
            outputInfo(threadInfo, threadInfo.getState());
            threadInfoStateMap.put(threadInfo, threadInfo.getState());
        }

        for (ThreadInfo threadInfo : threadInfoStateMap.keySet()) {
            threadInfo.start();
        }

        boolean isFinished = false;
        while (!isFinished) {
            for (Map.Entry<ThreadInfo, Thread.State> entry : threadInfoStateMap.entrySet()) {
                if (entry.getKey().getState() != entry.getValue()) {
                    outputInfo(entry.getKey(), entry.getValue());
                    threadInfoStateMap.put(entry.getKey(), entry.getKey().getState());
                }
            }

            isFinished = true;
            for (Map.Entry<ThreadInfo, Thread.State> entry : threadInfoStateMap.entrySet()) {
                isFinished = isFinished && (entry.getKey().getState() == Thread.State.TERMINATED);
            }
        }
    }

    public static void outputInfo(ThreadInfo threadInfo, Thread.State oldState) {
        System.out.printf("thread-id:%d,thread-name:%s,thread-priority:%d,current thread-state:%s,old state: %s\n",
                threadInfo.getId(),
                threadInfo.getName(),
                threadInfo.getPriority(),
                threadInfo.getState(),
                oldState);
    }
}
