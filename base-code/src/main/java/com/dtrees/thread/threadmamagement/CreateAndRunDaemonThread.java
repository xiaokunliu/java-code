package com.dtrees.thread.threadmamagement;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * Created by keithl on 2017/9/30.
 */

public class CreateAndRunDaemonThread {

    /**
     * 创建并执行守护线程
     */

}

class MyEvent{

    private String event;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}

class WriterTask implements Runnable{

    private Deque<MyEvent> deque;

    public WriterTask(Deque<MyEvent> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i ++){
            MyEvent event = new MyEvent();
            event.setDate(new Date());
            event.setEvent(String.format("the thread %s have generated an event",Thread.currentThread().getId()));
            deque.addFirst(event);

            //sleep
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CleanerTask extends Thread{

    private Deque<MyEvent> deque;

    public CleanerTask(Deque<MyEvent> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        while (true){
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete;

        if (deque.size() == 0){
            return;
        }

        delete = false;
        do{
            MyEvent event = deque.getLast();
            difference = date.getTime() - event.getDate().getTime();
            if (difference > 10000){
                System.out.printf("Cleaner: %s\n",event.getEvent());
                deque.removeLast();
                delete=true;
            }
        }while (difference > 10000);

        if (delete) {
            System.out.printf("Cleaner: Size of the queue: %d\n", deque.size());
        }
    }
}