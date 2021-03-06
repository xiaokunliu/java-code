##### 原型设计模式

* 定义
```comment 
Prototype模式是一种对象创建型模式，它采取复制原型对象的方法来创建对象的实例。
使用Prototype模式创建的实例，具有与原型一样的数据
```

* 特点
    1. 由原型对象自身创建目标对象。也就是说，对象创建这一动作发自原型对象本身。
    2. 目标对象是原型对象的一个克隆。也就是说，通过Prototype模式创建的对象，不仅仅与原型对象具有相同的结构，还与原型对象具有相同的值。
    3. 根据对象克隆深度层次的不同，有浅度克隆与深度克隆
    
* 应用场景

    - 在创建对象的时候，我们不只是希望被创建的对象继承其基类的基本结构，还希望继承原型对象的数据
    - 希望对目标对象的修改不影响既有的原型对象（深度克隆的时候可以完全互不影响)
    - 隐藏克隆操作的细节,很多时候，对对象本身的克隆需要涉及到类本身的数据细节