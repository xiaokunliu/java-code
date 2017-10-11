package com.dtrees.javase.primitive;

/**
 * Created by keithl on 2017/9/5.
 */
public class PrimitiveType {

    public static void main(String[] args) {

        // 基本数据类型
        // 8种基本类型   4种整型、2种浮点型、1种用于Unicode编码的字符单元类型char以及1种用于表示真值的boolean类型
//        short s = 1028383833839399393939393;    // 编译报错
//        short s = 32767;                //使用short的最大值
//        s = s + 1;                  //编译报错,关键是这里的1是属于int类型,
//        s += 1;                         //编译通过,自动转换为short的数据类型
//        System.out.println(s);          // -32768,数据溢出,

        // 在Java中,整型的范围与运行Java机器的代码无关 ==>体现可移植性

//        int a = 9 / 0;               // 抛出异常
//        float b = 9.0f / 0 ;         // Infinity
//        System.out.println(b);


        //位运算符:对移位运算符右侧的参数需要进行模32的运算（除非左边的操作数是long类型,在这种情况下需要对右侧操作数模64）
        int x = 3 << 4 ;    // 3 * 2^4
        int p = 80 >> 4;    // 80 / 2^4
        System.out.println(x);
        System.out.println(p);

        int l = 1 << 35;    // ==>  1 << 3(35 % 32 = 3) 左移3位
        int l2 = 1 >> 35;   //  右移3位

        System.out.println(l);
        System.out.println(l2);

        //String 为不可变的字符串,编译器可以让字符串共享

        // 检测字符串是否相等,equals 不用 ==,这个只能够确定两个字符串是否放在同一个位置上的
        System.out.println("hello".equals("world"));


        // 字符串常量是共享的,而 + 或者 substring等操作产生的结果并不是共享的

        //switch String、整数或者枚举常量
        String s = "";
        switch (s){
            case "ss":
                break;
            case "sa":
                break;
        }
    }
}
