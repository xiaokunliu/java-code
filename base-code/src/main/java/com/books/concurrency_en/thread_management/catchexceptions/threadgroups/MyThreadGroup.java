package com.books.concurrency_en.thread_management.catchexceptions.threadgroups;

public class MyThreadGroup extends ThreadGroup{

    public MyThreadGroup(String name){
        super(name);
    }

    // 覆盖uncatch Exception
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("The thread %s has thrown an Exception\n",t.getId());
        e.printStackTrace(System.out);
        System.out.printf("Terminating the rest of the Threads\n");
        interrupt();
    }
}
