package com.books.concurrency_en.thread_management.catchexceptions;


public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    // 继承一个线程未处理的异常处理器
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("An exception has been captured\n");
        System.out.printf("Thread: %s\n",t.getId());
        System.out.printf("Exception: %s: %s\n",e.getClass().getName(),e.getMessage());
        System.out.printf("Stack Trace: \n");
        e.printStackTrace(System.out);
        System.out.printf("Thread status: %s\n",t.getState());
    }
}
