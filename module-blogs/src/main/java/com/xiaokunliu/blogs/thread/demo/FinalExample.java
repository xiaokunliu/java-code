package com.xiaokunliu.blogs.thread.demo;

/**
 * date:2020/1/11 21:15
 * author:keithl
 * desc: business desc etc.
 */
public class FinalExample {

    // TODO write your logic code

    static FinalExample obj;
    final int j;
    int i;

    public FinalExample() {
        i = 1;
        j = 2;
    }


    public static void writer() {
        obj = new FinalExample();
    }

    public static void reader() {
        FinalExample object = obj;
        int a = object.i;
        int b = object.j;
    }

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                FinalExample.writer();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                FinalExample.reader();
            }
        }).start();

    }
}
