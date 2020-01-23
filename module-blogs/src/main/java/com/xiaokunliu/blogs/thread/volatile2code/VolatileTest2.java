package com.xiaokunliu.blogs.thread.volatile2code;

/**
 * date:2020/1/23 15:27
 * author:keithl
 * desc: business desc etc.
 */
public class VolatileTest2 {

    // TODO write your logic code
    private int j = 0;
    private int a = 0;

    public static void main(String[] args) {
        final VolatileTest2 test2 = new VolatileTest2();
        new Thread() {
            @Override
            public void run() {
                try {
                    test2.writer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                test2.reader();
            }
        }.start();
    }

    public void writer() {
//        TimeUnit.MICROSECONDS.sleep(100L);
        j = 90;
    }

    public void reader() {
        a++;
        System.out.println("before a is " + a);
        int a = j;
        a++;
        System.out.println("after a is " + a);
    }
}
