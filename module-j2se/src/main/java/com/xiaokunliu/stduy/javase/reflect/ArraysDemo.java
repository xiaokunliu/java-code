package com.xiaokunliu.stduy.javase.reflect;

import java.util.Arrays;

public class ArraysDemo {

    public static void main(String[] args) {


        /*
         * 注意工具类Arrays处理基本数据类型与引用类型的区别
         */
        //输出的结果为：[[I@d9660d]
        /*
         * 原因是int[]数组存放的是基本数据类型，而asList传递的参数是引用类型，所以当传递基本数据类型的
         * 数组进去之后，仅仅会当作一个new int[]的基本数据类型对象数组进去
         */
        System.out.println(Arrays.asList(new int[]{1, 2, 3, 4}));

        /*
         * String[]的元素存放的是引用类型，因此会将该数组打散，变成多个引用类型的参数传递
         */
        //输出的结果为：[1, 2, 3, 4]
        System.out.println(Arrays.asList("1", "2", "3", "4"));

        //[[I@64883c, [I@2c1e6b]
        System.out.println(Arrays.asList(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}));

        /*
         * 解释出现下面的原因：
         * 与签名的区别在于传递的参数个数发生改变，此时便会将每一个传递的参数单独看成一个泛型对应的引用类型，下面的9是属于自动装箱包装成Integer的对象
         */
        //[[Ljava.lang.String;@153f67e, [Ljava.lang.String;@15bdc50]
        System.out.println(Arrays.asList(new String[]{"1", "2", "3", "4"}, new Object[]{"5", "6", "7", "8"}, 9));
    }
}
