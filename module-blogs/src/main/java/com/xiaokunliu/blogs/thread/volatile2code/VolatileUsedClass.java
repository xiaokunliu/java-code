package com.xiaokunliu.blogs.thread.volatile2code;

import java.util.concurrent.TimeUnit;

/**
 * date:2020/1/11 14:33
 * author:keithl
 * desc: business desc etc.
 */
public class VolatileUsedClass {

    private static volatile int sharedVar = 10;
    private static volatile long shared = 10L;

    public static void main(String[] args) throws Exception {

//        testVolatileForMode();

//        testVolatileForLong();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    // modify the sharedVar
                    TimeUnit.MICROSECONDS.sleep(500L);
                    sharedVar = sharedVar + 1;
                    System.out.printf("%s modify the shared var with atomic %s  ...\n", "thread-1", sharedVar);
                } catch (Exception e) {

                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    // modify the sharedVar
                    TimeUnit.MICROSECONDS.sleep(510L);
                    System.out.printf("%s read the shared var with atomic %s \n", "thread-2", sharedVar);
                } catch (Exception e) {

                }
            }
        };

        t2.start();
        t1.start();

        t2.join();
        t1.join();

        System.out.println("finish the volatile for atomic opr ... ");
    }

    private static void testVolatileForLong() throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    // modify the sharedVar
                    TimeUnit.MICROSECONDS.sleep(500L);
                    shared = 20L;
                    System.out.printf("%s modify the shared var to %s  ...\n", "thread-1", shared);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    // modify the sharedVar
                    TimeUnit.MICROSECONDS.sleep(520L);
                    System.out.printf("%s read the shared var %s \n", "thread-2", shared);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };

        t2.start();
        t1.start();

        t2.join();
        t1.join();


        System.out.println("finish the volatile for long test ");
    }

    private static void testVolatileForMode() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // modify the sharedVar
                    TimeUnit.MICROSECONDS.sleep(500L);
                    sharedVar = 20;
                    System.out.printf("%s modify the shared var to %s  ...\n", "thread-1", sharedVar);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // read the value
                    TimeUnit.MICROSECONDS.sleep(520L);
                    System.out.printf("%s read the shared var %s \n", "thread-2", sharedVar);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });


        thread2.start();
        thread1.start();

        thread1.join();
        thread2.join();

        /**
         *  the result is:
         *      thread-1 modify the shared var to 20  ...
         *      thread-2 read the shared var 10
         *      finish the thread task...
         */
        System.out.println("finish the thread task...");
    }
}
