package com.dtrees.designs.patterns.singleton;

/**
 * Created by keithl on 2017/10/18.
 */

public class Person3 {

    /**
     * 支持线程安全
     */
    private String name;
    private static Person3 person;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //构造函数私有化
    private Person3() {
    }

    //提供一个全局的静态方法，使用同步方法
    public static synchronized Person3 getPerson() {
        if(person == null) {
            person = new Person3();
        }
        return person;
    }
}

