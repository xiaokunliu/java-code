package com.xiaokunliu.blogs.thread.base;

import java.util.concurrent.TimeUnit;

/**
 * date:2019/9/25 10:46
 * author:keithl
 */
public class ThreadInterrupt {

    public static void main(String[] args) throws Exception {

        // 线程中断方法
        Thread task = new Thread(new Runnable() {
            @Override
            public void run() {
                int number = 1;
                while (true) {
                    if (isPrime(number)) {
                        System.out.printf("the current number=%s is prime", number);
                        System.out.println();
                    }
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println();
                        System.out.printf("the current thread=%s have been interrupted", Thread.currentThread().getName());
                        return;
                    }
                    number++;
                }
            }

            private boolean isPrime(int number) {
                if (number <= 2) {
                    return true;
                }
                int count = number >> 1;
                for (int j = 2; j < count; j++) {
                    if ((number % j) == 0) {
                        return false;
                    }
                }
                return true;
            }
        });
        task.start();
//        System.exit(0);
        TimeUnit.SECONDS.sleep(2);

        // 中断当前任务
        task.interrupt();
    }
}
