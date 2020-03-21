package com.xiaokunliu.interview.j2se.designs.patterns.singleton;

/**
 * Created by keithl on 2017/10/18.
 */

public class Person4 {

    private static Person4 person;
    /**
     * 支持线程安全的双重实例
     */
    private String name;

    //构造函数私有化
    private Person4() {
    }

    //提供一个全局的静态方法
    public static Person4 getPerson() {
        if (person == null) {
            synchronized (Person4.class) {
                if (person == null) {
                    person = new Person4();
                }
            }

        }
        return person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
