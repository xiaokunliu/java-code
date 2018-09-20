package com.books.concurrency_en.thread_management;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by keithl on 2017/9/23.
 * 创建并执行线程
 */
public class DefineThread {

    public static void main(String[] args) {

        /**
         * ## 执行run方法
         *  public void run() {
            if (target != null) {
                target.run();
            }
         }
         */
        // 创建线程
        //1
        Thread t = new Thread(){
            @Override
            public void run() {  // 覆盖父类方法
                System.exit(0);     //执行这个语句会导致所有在其之后执行的线程退出程序
                System.out.println("thread run ...");
            }
        };
        t.start();

        //2
        DefineThread1 thread1 = new DefineThread1();
        thread1.start();

        //3
        Thread task = new Thread(new DefineTask());
        task.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("could not execute here ....");
            }
        }){
            @Override
            public void run() {
                System.out.println("finally would be execute here ...");
            }
        }.start();

        //4 创建多线程另一种方式
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        new Thread(futureTask).start();

        try {
            Thread.sleep(1000);
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


// 定义线程方式1
class DefineThread1 extends Thread{

    @Override
    public void run() {
        System.out.println("define thread run ...");
    }
}

class DefineTask implements Runnable{

    @Override
    public void run() {
        System.out.println("define task run ...");
    }
}