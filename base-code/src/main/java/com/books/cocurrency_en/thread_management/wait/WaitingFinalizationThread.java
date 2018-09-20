package com.books.cocurrency_en.thread_management.wait;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by keithl on 2017/9/29.
 */

public class WaitingFinalizationThread {

    /**
     * 应用场景:
     * 一个程序在继续执行其余的操作之前要开始初始化所需的资源,这时候可以将处理初始化所需的资源都分别放在一个单独的线程中,
     * 需要等待线程执行任务之后方可进行下一步操作
     */

    // 使用join()方法来实现这个目的
    public static void main(String[] args) {
        DataSourcesLoader dataSourcesLoader = new DataSourcesLoader();
        Thread dataThread = new Thread(dataSourcesLoader);


        NetWorkLoader netWorkLoader = new NetWorkLoader();
        Thread netThread = new Thread(netWorkLoader);

        dataThread.start();
        netThread.start();

        try {
            /**
             * 还提供额外的方法
             * join (long milliseconds)             // 给予在给定的时间内执行完成,否则将不做等待
             * join (long milliseconds, long nanos)
             */
            dataThread.join();
            netThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 资源全部加载完毕才会继续往下执行
        System.out.printf("Main Configuration have been loaded ....");
    }
}

class DataSourcesLoader implements Runnable{

    @Override
    public void run() {
        System.out.printf("Beginning data sources loading: %s\n",new Date());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Data sources loading has finished:%s\n",new Date());
    }
}

class NetWorkLoader implements Runnable{

    @Override
    public void run() {
        System.out.printf("Beginning network sources loading: %s\n",new Date());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("network sources loading has finished:%s\n",new Date());
    }
}
