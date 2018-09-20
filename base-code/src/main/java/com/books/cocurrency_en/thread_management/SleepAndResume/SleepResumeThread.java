package com.books.cocurrency_en.thread_management.SleepAndResume;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by keithl on 2017/9/23.
 */

public class SleepResumeThread {

    // 使用背景
    /**
     * Sometimes, you'll be interested in interrupting the execution of Thread during a determined period of time.
     * For example, a thread in a program checks a sensor state once per minute. The rest of the time, the thread does nothing.
     * During this time, the thread doesn't use any resources of the computer.
     * After this time, the thread will be ready to continue with its execution when the JVM chooses it to be executed.
     * You can use the sleep() method of the Thread class for this purpose. This method receives an integer as the parameter indicates the number of milliseconds that the thread suspends its execution. When the sleeping time ends, the thread continues with its execution in the instruction,
     * after the sleep() method calls, when the JVM assigns them CPU time.
     Another possibility is to use the sleep() method of an element of the TimeUnit enumeration.
     This method uses the sleep() method of the Thread class to put the current thread to sleep, but it receives the parameter in the unit that it represents and converts it to milliseconds.
     In this recipe, we will develop a program that uses the sleep() method to write the actual date every second.
     */

    public static void main(String[] args) {
        FileClock fileClock = new FileClock();
        Thread thread = new Thread(fileClock);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();     // 中断线程

        /**
         * Java concurrency API has another method that makes a Thread object leave the CPU.
         * It's the yield() method, which indicates to the JVM that the Thread object can leave the CPU for other tasks.
         * The JVM does not guarantee that it will comply with this request. Normally, it's only used for debug purposes
         */
    }
}

class FileClock implements Runnable{

    @Override
    public void run() {
        for (int i=0;i < 10; i++){
            System.out.printf("%s\n",new Date());
            //sleep
            try {
                /**
                 * 调用sleep方法时,Thread将会离开CPU并且处于可执行状态一段时间,
                 * 在这段时间线程没有被唤醒,这段空闲时间可以用来执行其他的任务
                 *
                 * 调用yield方法时,Thread将会离开CPU并且处于可执行状态一段时间,这时候也可以用于执行其他任务
                 * 但是JVM并不能保证它可以满足这样的要求,也就是不确定会不会离开CPU并让出空闲时间,只能用于测试
                 */
                TimeUnit.SECONDS.sleep(4);          // 线程的sleep()方法,这是另外一种使用方式
//                Thread.yield();
            } catch (/*Interrupted*/Exception e) {
                System.out.printf("The FileClock has been interrupted");
            }
        }
    }
}