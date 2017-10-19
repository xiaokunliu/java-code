package com.dtrees.designs.patterns.factory.factorymethod;

/**
 * Created by keithl on 2017/10/18.
 */

public class AppleFactory implements FruitFactory{

    @Override
    public Fruit getFruit() {
        return new Apple();
    }
}
