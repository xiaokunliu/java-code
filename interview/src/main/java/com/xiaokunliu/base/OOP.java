package com.xiaokunliu.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by keithl on 2017/11/13.
 */
public class OOP {

    /**
     * 面向对象编程OOP
     * 1.类Class:是构建对象的模板
     *      封装:数据隐藏,将数据和行为组合在一个称为类的模板中,并且对外界使用对象隐藏数据的具体实现方式
     *          对象中的数据称为实例域,操纵数据的过程称为方法
     *          每个实例对象都有一组特定的实例域值,这些值的集合就是对象的状态
     *      继承:类可以通过扩展另一个类来建立,在Java中,所有的类都源自一个Object
     *      多态:一个对象变量可以引用多种实际类型的现象
     *          动态绑定:在运行时能够自动地选择调用哪个方法的现象
     *
     * 2.对象三个特性:
     *      对象行为:可以对对象施加哪些操作,或可以对对象施加哪些方法
     *      对象状态:当施加那些方法时,对象如何响应
     *      对象标识:如何辨别具有相同行为与状态不同的对象
     *
     * 3.类之间的关系
     *      依赖,uses-a,如订单使用Account来查看用户信用状态,Order与Account
     *      聚合,has-a,如订单包含订单列表项
     *      继承,is-a
     *
     * 4.类的UML关系
     *      继承:直线 + 三角形
     *      接口继承:虚线 + 三角线
     *      依赖:虚线 + 箭头
     *      聚合:菱形 + 直线
     *      关联:直线
     *      直接关联:直线 + 箭头
     *
     * 5.创建对象执行顺序:
     *      构造代码块 > 构造器  >  赋值
     *
     * 6.构造器
     *      构造器与类同名
     *      每个类可以有一个以上的构造器
     *      构造器可以有0个,1,...以上的参数
     *      构造器没有返回值
     *      构造器总是伴随着new操作一起调用
     *      仅仅当类没有提供任何构造器的时候会提供默认的构造器
     *  调用构造器的处理步骤:
     *      1.所有数据域被初始化为默认值（0,false或者null）
     *      2.按照在类中声明的出现次序,依次执行所有域初始化语句和初始化块
     *      3.若构造器中第一行调用了第二个构造器,则执行第二个构造器主体
     *      4.执行当前构造器
     *
     * 7.使用静态方法场景
     *      一个方法不需要访问对象的方法
     *      一个方法只需要访问类的静态域
     *
     * 8.Factory方法使用场景
     *      无法命名构造器,因为构造器必须与类命名相同
     *      使用构造器的时候,无法改变构造的对象类型,Factory可以返回定义的对象或其子类对象
     *
     * 9.方法参数
     *      值调用:表示方法接受的是调用者提供的值
     *      引用调用:表示方法接受的是调用者提供的变量地址
     *      方法使用情况:
     *          一个方法不能修改一个基本数据类型的参数
     *          一个方法可以改变一个对象参数的状态
     *          一个方法不能实现让对象参数引用一个新的对象
     *
     * 10.重载:相同的方法、不同的参数、子类重载方法修饰符必须要大于等于父类方法
     *
     * 11.finalize:将在垃圾回收器清除对象之前调用,是一个方法
     *
     * 12.设置类路径
     * javac -classpath path:./xxxx/xxx.jar className.java
     * java -classpath path:./xxxx/xxx.jar className
     *
     * 13.反射:是指在程序运行期间发现更多的类以及其属性的能力
     *
     * 14.this 和 super
     *      this:一是隐式参数,二是调用该类其他的构造器
     *      super:一是调用超类的方法,二是调用超类的构造器
     *      注意点:调用构造器的时候,this和super只能在构造器的第一个语句出现,构造参数既可以传递给本类还可以传递给超类
     *
     * 15.自动打包与自动拆包
     *      自动打包规范:要求boolean、byte、char<=127,介于-128 ~ 127之间的short和int被包装到固定的对象中
     *      打包与拆包是编译器认可的,不是虚拟机
     */


    static {
        System.out.println("执行static静态代码块....");
    }

    private int a = 0;

    {
        a = 2;
        b = 0;
        System.out.println("执行初始化块 .... ");
    }

    private int b = 1;

    public OOP(){
        System.out.println("执行构造器,总是最后执行...");
//        a = 3;
//        b = 2;
    }

//    {
//        a = 4;
//        b = 3;
//    }

    public void display(){
        System.out.println("a=" + a + ",b=" + b);
    }

    // java 的equals方法编写规范

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        OOP oop = (OOP) o;

        return new EqualsBuilder()
                .append(a, oop.a)
                .append(b, oop.b)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(a)
                .append(b)
                .toHashCode();
    }

    public static void main(String[] args) {

        //执行顺序:静态代码块 > 构造代码块 > 赋值  >  构造器
        OOP p = new OOP();
        p.display();
    }
}
