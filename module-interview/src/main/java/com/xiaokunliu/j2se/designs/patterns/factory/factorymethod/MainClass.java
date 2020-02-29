package com.xiaokunliu.j2se.designs.patterns.factory.factorymethod;

/**
 * Created by keithl on 2017/10/18.
 */

public class MainClass {

    public static void main(String[] args) {
        //获得AppleFactory
        FruitFactory ff = new AppleFactory();
        //通过AppleFactory来获得Apple实例对象
        Fruit apple = ff.getFruit();
        apple.get();

        //获得BananaFactory
        FruitFactory ff2 = new BananaFactory();
        Fruit banana = ff2.getFruit();
        banana.get();
    }
}
