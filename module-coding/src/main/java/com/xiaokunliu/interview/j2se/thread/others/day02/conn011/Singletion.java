package com.xiaokunliu.interview.j2se.thread.others.day02.conn011;

public class Singletion {

    public static Singletion getInstance() {
        return InnerSingletion.single;
    }

    private static class InnerSingletion {
        private static Singletion single = new Singletion();
    }

}
