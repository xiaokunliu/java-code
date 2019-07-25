package com.xiaokunliu.oop;

/**
 * Created by keithl on 2017/11/5.
 */

public class Person {

    public String name = "person";
    public final static String NAME = "PERSON";


    public Person(String name){
        System.out.println("execute Person constructors ....");
    }

//    public Person(){
//        System.out.println("execute Person constructors ....");
//    }

//    public String getName(){
//        return this.name;
//    }

    public void showName() {
        System.out.println("Person show name method ...");
    }
}
