package com.xiaokunliu.interview.j2se.javase.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest {


    public static void demo_3() {
        /*
         * 集合转成数组呢？
         *
         * 使用的就是Collection接口中的toArray方法。
         *
         * 集合转成数组：可以对集合中的元素操作的方法进行限定。不允许对其进行增删。
         *
         *
         */

        List<String> list = new ArrayList<String>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");


        /*
         * toArray方法需要传入一个指定类型的数组。
         * 长度该如何定义呢？
         * 如果长度小于集合的size，那么该方法会创建一个同类型并和集合相同size的数组。
         * 如果长度大于集合的size，那么该方法就会使用指定的数组，存储集合中的元素，其他位置默认为null。
         *
         * 所以建议，最后长度就指定为，集合的size。
         */
        String[] arr = list.toArray(new String[list.size()]);

        System.out.println(Arrays.toString(arr));

    }

    public static void demo_2() {

        /*
         * 如果数组中的元素是对象，那么转成集合时，直接将数组中的元素作为集合中的元素进行集合存储。
         *
         * 如果数组中的元素是基本类型数值，那么会将该数组作为集合中的元素进行存储。
         *
         */
        int[] arr = {31, 11, 51, 61};

        List<int[]> list = Arrays.asList(arr);

        System.out.println(list);
    }

    /**
     *
     */
    public static void demo_1() {
        /*
         * 重点：List asList(数组)将数组转成集合。
         *
         * 好处：其实可以使用集合的方法操作数组中的元素。
         * 注意：数组的长度是固定的，所以对于集合的增删方法是不可以使用的
         * 否则会发生UnsupportedOperationException
         *
         *
         */
        String[] arr = {"abc", "haha", "xixi"};

        boolean b = myContains(arr, "xixi");
        System.out.println("contains:" + b);

        List<String> list = Arrays.asList(arr);
        boolean b1 = list.contains("xixi");
        System.out.println("list contaisn:=" + b1);
//		list.add("hiahia");//UnsupportedOperationException

        System.out.println(list);
    }

    public static boolean myContains(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key))
                return true;
        }
        return false;
    }

    //toString的经典实现。
    public static String myToString(int[] a) {
        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {//中间省略条件判断，提高了效率。
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }


}
