package com.xiaokunliu.interview.j2ee;

/**
 * project:java-code
 * file:JPA
 * package:com.xiaokunliu.j2ee
 * date:2018/10/3 下午8:45
 * author:keithl
 */
public class JPA {

    // 名称解释说明

    /**
     * 参考链接：
     * https://blog.csdn.net/chenchunlin526/article/details/69939337
     * https://www.jianshu.com/p/b934b0d72602
     * https://blog.csdn.net/qq_27093465/article/details/52527270
     * https://www.geeksforgeeks.org/pojo-vs-java-beans/
     *
     * JavaBean: 是一种Java语言写成的可重用组件,它的方法命名，构造及行为必须符合特定的约定。
     * 1、这个类必须具有一个公共的(public)无参构造函数；
     * 2、所有属性私有化（private）；
     * 3、私有化的属性必须通过public类型的方法（getter和setter）暴露给其他程序，并且方法的命名也必须遵循一定的命名规范。 
     * 4、这个类应是可序列化的。（比如可以实现Serializable 接口，用于实现bean的持久性）
     *
     * POJO（Plain Ordinary Java Object）:POJO就是一个简单的普通的Java对象，它不包含业务逻辑或持久逻辑等，但不是JavaBean、EntityBean等，不具有任何特殊角色和不继承或不实现任何其它Java框架的类或接口。
     *
     * VO(Value Object/View Object): POJO在表现层的体现。 当我们处理完数据时，需要展现时，这时传递到表现层的POJO就成了VO。它就是为了展现数据时用的。
     *
     * BO: POJO在业务层的体现，对于业务操作来说，更多的是从业务上来包装对象，如一个User的BO，可能包括name, age, sex, privilege, group等，这些属性在数据库中可能会在多张表中，因为每一张表对应一个PO，而我们的BO需要这些PO组合起来(或说重新拼装)才能成为业务上的一个完整对象。
     *
     * PO: POJO在持久层的体现，对POJO持久化后就成了PO。在o/r映射的时候出现的概念，如果没有o/r映射，没有这个概念存在了。通常对应数据模型(数据库),本身还有部分业务逻辑的处理。可以看成是与数据库中的表相映射的java对象。最简单的PO就是对应数据库中某个表中的一条记录，多个记录可以用PO的集合。PO中应该不包含任何对数据库的操作。
     *
     * DAO: PO持久化到数据库是要进行相关的数据库操作的(CRUQ)，这些对数据库操作的方法会统一放到一个Java对象中，这就是DAO。
     *
     * DTO(Data Transfer Object): POJO在系统间传递时。当我们需要在两个系统间传递数据时，一种方式就是将POJO序列化后传递，这个传递状态的POJO就是DTO。
     *
     * EJB(Enterprise JavaBean): 我认为它是一组"功能"JavaBean的集合。上面说了JavaBean是实现了一种规范的Java对象。这里说EJB是一组JavaBean，的意思是这一组JavaBean组合起来实现了某个企业组的业务逻辑。这里的一组JavaBean不是乱组合的，它们要满足能实现某项业务功能的搭配。找个比方，对于一身穿着来说，包括一顶帽子，一件衣服，一条裤子，两只鞋。这穿着就是EJB，其它的就是一个JavaBean
     */


    /**                  Application
     *                      JPA规范
     *       JPA实现  Hibernate/TopLink/其他ORM框架
     *                      数据库
     *
     */

    // JPA 映射规则
    /**
     *  1。数据表映射到对应的实体类
     *      使用实体类对其CRUD -- 对应到实现对这个数据表进行CRUD操作
     *  2。数据表的行映射到实体类实例对象
     *      实体类会生成很多实体，每个实体就对应数据表中的每一行记录，当在应用中修改实体对象时，JPA会转换成对指定数据表中的指定记录行进行操作
     *  3。数据表的列（字段）映射实体的属性
     *      当在应用中修改某个实体对象的指定属性时，JPA会转换成对数据表中指定的数据行/指定的数据列的修改
     */


    // JPA 规范
    /**
     *  实体：其实就是一个普通的POJO，即POJO（Plain Ordinary Java Object）简单的Java对象，实际就是普通JavaBeans，是为了避免和EJB混淆所创造的简称
     *  EntityManager：实体只是和底层数据库具有映射关系的POJO，本身并没有具备持久化能力，必须使用EntityManager来对实体类进行操作时JPA才会将这种操作转换为对底层数据库的操作
     *  JPQL查询：JPA提供Query接口来执行查询
     */


    //JPA 实体
    /**
     * 1。实体
     *       持久化上下文persistence context 以及持久化单元 persistence unit
     *  持久化上下文是一组处于托管状态上下文实体所组成的集合，处于EntityManager之下，可以通过EntityManager与持久化上下文进行交互
     *  EntityManager负责跟踪持久化上下文所有实体的状态，当应用程序改变持久化上下文中的实体状态后，EntityManager将会根据指定的flush模式将
     *  实体的状态写入底层数据库，如果持久化上下文被关闭，其将会脱离EntityManager的管理，进入托管状态，此时对实体所做的修改将不回自动同步到
     *  底层数据库
     *
     *  2。持久化单元
     *  将由persistence.xml文件定义，在该配置文件中的<persistence-unit></persistence-unit>定义持久化单元
     *  对于persistence.xml存放的位置
     *      1。 程序打包成jar包，则应该将该文件放在应用类加载路径的META-INF路径下
     *      2。 打包成EJB包，则应该将该文件存放在EJB JAR下的META-INF路径下
     *      3。 对于WEB程序，不论是否有没有打成WAR包，则应该存放在WEB-INF/classes/META-INF下，
     */

    // JPA实体类的要求 -- 规范
    /**
     *  1。 提供无参数的构造函数
     *  2。 提供标识属性，通常映射数据库表的主键字段
     *  3。 为每个属性字段提供getter和setter方法
     *  4。 使用非final类，JPA实现需要在运行时期生成动态代理
     *  5。 重写equals和hasCode方法，需要将实体放入Set集合中
     */

    // 实体类的状态
    /**
     *  新建：实体由new创建，且尚未与EntityManager关联过的实体被认为处于新建状态，
     *  托管：托管状态下的实体在数据库中由对应的记录，并拥有一个持久化标识
     *  脱管：实体在托管的状态下，与之关联的EntityManager被关闭，实体就变成脱管状态
     *  被删除：当EntityManager调用remove方法删除指定的实体之后，该实体进入被删除的状态，被删除的实体还关联着某个持久化上下文，如果被删除的实体还关联着持久化上下文，并且对应
     *  的记录也即将从数据库中被删除
     */

    // 继承关系映射
    /**
     *  1。 整个类层次对应一张表
     *  2。 链接子类的映射策略
     *  3。 每个几天类对应一张表
     */

    // 使用抽象实体与非实体父类  -- entity 包下

    // 实体生命周期与监听器
    /**
     *  新建状态 -- 托管状态
     *      1。 程序执行EntityManager.persist()
     *      2。 回调实体类中的@PrePersisit修饰的生命周期方法
     *      3。 底层数据库执行insert的sql
     *      4。 回调实体@PostPersisit修饰的生命周期方法
     * 托管状态  --  调用实体的setter方法来修改属性信息
     *      1。 程序调用set方法修改属性信息
     *      2。 回调实体中由@PreUpdate修饰的生命周期的方法
     *      3。 底层数据库执行update方法
     *      4。 回调实体@PostUpdate修饰的生命周期方法
     * 托管状态  --   refresh方法
     *      1。 程序执行EntityManager.refresh()
     *      2。 数据记录加载到当前实体中
     *      3。 回调实体@PostLoad修饰的生命周期方法
     * 当实体信息传递到服务端的表现层中，那么实体已经脱离EntityManager管理，进入脱管状态
     * 脱管状态 -- 调用merge方法将实体数据保存到数据库中，其一不会将当前实体转换为托管状态，其二产生的副本是处于托管状态
     *      1。 程序执行EntityManager.merge()
     *      2。 回调实体中由@PreUpdate修饰的生命周期的方法
     *      3。 底层数据库执行update方法
     *      4。 回调实体@PostUpdate修饰的生命周期方法
     *  脱管状态 -- 调用remove方法进入被删除状态
     *      1。 程序执行EntityManager.remove()
     *      2。 回调实体中由@PreRemove修饰的生命周期的方法
     *      3。 准备执行但还未在数据库底层执行delete的sql
     *  被删除状态 -- JPA自动将从底层数据库中删除该实体记录
     *      1。 底层执行delete的sql
     *      2。 回调实体中由@PrePost修饰的生命周期的方法
     */

    // 生命周期的方法必须满足以下两个条件
    /**
     *  1。 生命周期的方法满足public void methodName的方法签名，
     *  2。 生命周期的方法可以有任何名称，但不要使用ejb开头
     */

    // 配置全局默认的监听器
    // 在xml中进行配置，先在java中定义好监听器类，然后在xml中配置全局默认的实体监听器

    // 排除监听器 -- 使用注解的方式

}
