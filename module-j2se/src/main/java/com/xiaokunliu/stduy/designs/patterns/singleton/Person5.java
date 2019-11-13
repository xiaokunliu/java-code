package com.xiaokunliu.stduy.designs.patterns.singleton;

/**
 * Created by keithl on 2017/10/18.
 */

public class Person5 {

    // 单例编写优化
    private Person5() {
    }

    public static Person5 getPerson() {
        return SingletonClass.PERSON;
    }

    public static final class SingletonClass {
        public static Person5 PERSON = new Person5();
    }
}
