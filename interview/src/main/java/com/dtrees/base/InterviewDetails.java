package com.dtrees.base;

/**
 * Created by keithl on 2017/11/7.
 */

public class InterviewDetails {

    public static void main(String[] args) {
//        String s = new String("abc");
//        String s1 = s.substring(0,s.length());  // return ((beginIndex == 0) && (endIndex == value.length)) ? this:new String(value, beginIndex, subLen);
//        System.out.println(s == s1);

        double d = 123456;
        Double d1 = new Double(123456);
        System.out.println(d == d1);    // 比较的时候会将包装类型拆箱为基本数据类型
    }

}
