package com.books.concurrency_en.thread_management.catchexceptions;

public class ProcessUncontrolledException {

    // 处理线程无法控制的异常
    /**
     *  Checked exceptions: 编译过程抛出异常
     *      These exceptions must be specified in the throws clause of a method or caught inside them. For example, IOException or ClassNotFoundException .

        Unchecked exceptions: 运行过程抛出异常
            These exceptions don't have to be specified or caught. For example,  NumberFormatException .
     */

    public static void main(String[] args) {

        ExceptionTask task = new ExceptionTask();
        Thread thread=new Thread(task);
        // 为线程设置默认异常处理器
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}

