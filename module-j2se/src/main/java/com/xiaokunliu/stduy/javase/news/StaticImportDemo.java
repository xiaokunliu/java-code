package com.xiaokunliu.stduy.javase.news;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static java.util.Collections.max;
import static java.util.Collections.sort;

public class StaticImportDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("abc3");
        list.add("abc7");
        list.add("abc1");

        out.println(list);

        sort(list);

        System.out.println(list);


        String max = max(list);
        out.println("max=" + max);
    }

}
