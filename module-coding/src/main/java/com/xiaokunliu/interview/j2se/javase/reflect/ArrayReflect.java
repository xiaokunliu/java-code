package com.xiaokunliu.interview.j2se.javase.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class ArrayReflect {

    public String[] strArr = {"xiao", "kun", "keith", "Jason"};
    public String str = "mybooks";


    public static void main(String[] args) throws Exception {

        ArrayReflect obj = new ArrayReflect();
        Field f = obj.getClass().getField("strArr");
        if (f.getType().isArray()) {
            int len = Array.getLength(f.get(obj));
            for (int i = 0; i < len; i++) {
                System.out.println(Array.get(f.get(obj), i));
            }
        } else {
            System.out.println(f.get(obj));
        }
    }
}
