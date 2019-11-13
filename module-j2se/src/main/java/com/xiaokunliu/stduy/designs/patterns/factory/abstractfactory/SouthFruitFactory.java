package com.xiaokunliu.stduy.designs.patterns.factory.abstractfactory;


public class SouthFruitFactory implements FruitFactory {

    @Override
    public Fruit getApple() {
        return new SouthApple();
    }

    @Override
    public Fruit getBanana() {
        return new SouthBanana();
    }
}
