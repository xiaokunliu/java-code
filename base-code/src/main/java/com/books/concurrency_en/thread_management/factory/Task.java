package com.books.concurrency_en.thread_management.factory;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable{

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
