package com.books.concurrency_en.thread_management.threadgroup;

import java.util.concurrent.TimeUnit;

public class ThreadGroups {

    public static void main(String[] args) {

//        First, create a  ThreadGroup object and call them  Searcher .
        ThreadGroup threadGroup = new ThreadGroup("Searcher");

//        Then, create a  SearchTask object and a  Result object
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);

        // last,use thread group to create 10 thread
        for (int i=0; i<5; i++) {
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 列出线程组中的相关信息
        System.out.printf("Number of Threads: %d\n",threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();

        // Use the  activeCount() and  enumerate() methods to know how many  Thread
        //objects are associated with the  ThreadGroup objects and get a list of them. We can
        //use this method to get, for example, the state of each  Thread
        Thread[] threads=new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i=0; i<threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n",threads[i].getName(),threads[i].getState());
        }

//        Call the method  waitFinish() . We will implement this method later. It will wait
//        until one of the threads of the  ThreadGroup objects ends.
        waitFinish(threadGroup);

//        Interrupt the rest of the threads of the group using the  interrupt() method.
        threadGroup.interrupt();
    }

    //Implement the  waitFinish() method. It will use the  activeCount() method to
    //control the end of one of the threads.
    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount()>9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
