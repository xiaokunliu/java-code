package com.dtrees.javase.oop;

/**
 * Created by keithl on 2017/11/21.
 */

public class A extends B{

    int a = 0;

    {
        b = 2;
        System.out.println("执行A的代码块...");
    }

    int b = 9;

    static{
        System.out.println("执行A的静态代码块....");
    }

    public A(){
        a = 3;
        b = 4;
        System.out.println(String.format("执行A的构造器[%d,%d]",a,b));
    }

    public static void main(String[] args) {
        /**
         *
         执行B的静态代码块....
         执行A的静态代码块....
         执行B的代码块...
         执行B的构造器[3,4]
         执行A的代码块...
         执行A的构造器[3,4]
         */
        new A();
    }
}
