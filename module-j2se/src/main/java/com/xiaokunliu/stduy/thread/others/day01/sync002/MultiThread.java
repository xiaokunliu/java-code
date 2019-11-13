package com.xiaokunliu.stduy.thread.others.day01.sync002;

/**
 * 关键字synchronized取得的锁都是对象锁，而不是把一段代码（方法）当做锁，
 * 所以代码中哪个线程先执行synchronized关键字的方法，哪个线程就持有该方法所属对象的锁（Lock），
 * <p>
 * 在静态方法上加synchronized关键字，表示锁定.class类，类一级别的锁（独占.class类）。
 */
public class MultiThread {

    private int num = 0;

    //注意观察run方法输出顺序
    public static void main(String[] args) {

        //俩个不同的对象
        final MultiThread m1 = new MultiThread();
        final MultiThread m2 = new MultiThread();

        // 两个线程分别得到自己的对象锁,不存在同步的效果,同时也不存在线程安全的问题
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m1.printNum("a");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m2.printNum("b");
            }
        });

        t1.start();
        t2.start();

        // 若要实现tag a 执行完毕后再执行tag b,需要在num上添加static方法,作为多个线程之间的共享数据,同时方法添加上static,此时的锁是类的锁,保证是同一个锁
    }

    /**
     * static
     */
    public synchronized void printNum(String tag) {
        try {

            if (tag.equals("a")) {
                num = 100;
                System.out.println("tag a, set num over!");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("tag b, set num over!");
            }

            System.out.println("tag " + tag + ", num = " + num);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
