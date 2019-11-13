package com.xiaokunliu.stduy.designs.patterns.factory.factorymethod;

/**
 * Created by keithl on 2017/10/18.
 */

public class BananaFactory implements FruitFactory {

    @Override
    public Fruit getFruit() {
        return new Banana();
    }
}
