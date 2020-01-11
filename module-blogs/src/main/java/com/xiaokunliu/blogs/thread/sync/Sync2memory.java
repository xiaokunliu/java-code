package com.xiaokunliu.blogs.thread.sync;

import java.util.concurrent.TimeUnit;

/**
 * date:2020/1/11 14:33
 * author:keithl
 * desc: business desc etc.
 */
public class Sync2memory {

    private static Integer sharedVar = 10;

    public static void main(String[] args) throws Exception {
        // synchronized 同步内存语义

        // 场景： 现在有一个共享变量sharedVar，执行写操作需要耗时500ms，而有一个线程由于网络原因延迟读操作耗时600ms，另一个线程正常读操作
        // 期望的场景是希望写数据之后其他线程也知道数据已经发生改变了,需要读取最新的数据
//        testForReadWrite();
//
        testForReadWriteWithSync();

        TimeUnit.SECONDS.sleep(2L);
        System.out.printf("finish the thread task,the final sharedVar %s ....\n", sharedVar);
    }

    private static void testForReadWriteWithSync() throws Exception {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MICROSECONDS.sleep(500L);
                    synchronized (sharedVar) {
                        // modify the sharedVar
                        System.out.printf("%s modify the shared var ...\n", "thread-1");
                        sharedVar = 20;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MICROSECONDS.sleep(600L);
                    synchronized (sharedVar) {
                        System.out.printf("%s read the shared var %s \n", "thread-2", sharedVar);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (sharedVar) {
                        System.out.printf("%s read the shared var %s \n", "thread-3", sharedVar);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        thread2.start();
        thread3.start();
        thread1.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }

    private static void testForReadWrite() throws Exception {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MICROSECONDS.sleep(500L);
                    // modify the sharedVar
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
                    TimeUnit.MICROSECONDS.sleep(600L);
                    System.out.printf("%s read the shared var %s \n", "thread-2", sharedVar);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.printf("%s read the shared var %s \n", "thread-3", sharedVar);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        thread2.start();
        thread3.start();
        thread1.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }
}
