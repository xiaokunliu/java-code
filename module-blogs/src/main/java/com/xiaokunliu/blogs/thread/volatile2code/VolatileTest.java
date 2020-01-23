package com.xiaokunliu.blogs.thread.volatile2code;

import java.util.concurrent.TimeUnit;

/**
 * date:2020/1/23 10:37
 * author:keithl
 * desc: business desc etc.
 */
public class VolatileTest {

    private boolean finised = false;

    public static void main(String[] args) throws InterruptedException {
        final VolatileTest volatileTest = new VolatileTest();
        Thread p = new Thread() {
            @Override
            public void run() {
                try {
                    volatileTest.producer();
                } catch (Exception e) {

                }
            }
        };

        Thread c = new Thread() {
            @Override
            public void run() {
                try {
                    volatileTest.consume();
                } catch (Exception e) {

                }
            }
        };
        p.start();
        c.start();

        p.join();
        c.join();
        System.out.println("have done ");
    }

    public void producer() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        finised = true;
        System.out.println("have finished product done ....");
    }

    public void consume() {
//        TimeUnit.SECONDS.sleep(2);
        while (!finised) {
            // nothing
        }
        System.out.println("have consume product done ");
    }
}
