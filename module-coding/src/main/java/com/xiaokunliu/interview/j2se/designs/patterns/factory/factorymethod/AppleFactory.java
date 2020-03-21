package com.xiaokunliu.interview.j2se.designs.patterns.factory.factorymethod;

/**
 * Created by keithl on 2017/10/18.
 */

public class AppleFactory implements FruitFactory {

    @Override
    public Fruit getFruit() {
        return new Apple();
    }
}
