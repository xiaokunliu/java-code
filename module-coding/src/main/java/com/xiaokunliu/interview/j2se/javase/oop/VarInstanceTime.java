package com.xiaokunliu.interview.j2se.javase.oop;

/**
 * <p>Title: 实例变量初始化时机</p>
 * <p>Description: 实例变量初始化的时机，即直接定义声明且初始化，代码块初始化以及构造器的初始化，构造器初始化的时机
 * 相比于前两种都慢，而前两种初始化的时机与在代码中初始化的顺序有关
 * </p>
 * <p>Company: wind</p>
 *
 * @author keith
 * @date 2015-5-29
 */
public class VarInstanceTime {

    static {
        System.out.println("执行静态代码块");
    }

    String name;
    int age;

//	double weight = 3.0;
    /**
     * 最后输出的weight是3.0，不是2.0
     */
    double weight = 3.0;    // 在构造代码块中执行

    /**
     * 代码块
     */ {
        System.out.println("执行非静态代码块");
        /**
         * 注意：
         * 编译器会检测上下文是否有定义该变量，但是执行的时候
         * 代码执行与初始化设置执行时机与代码顺序有关
         */
        weight = 2.0;
    }

    /**
     * <p>Title: </p>
     * <p>Description: 构造器</p>
     *
     * @param name
     * @param age
     */
    public VarInstanceTime(String name, int age) {
        System.out.println("执行构造器....");
        this.name = name;
        this.age = age;
        System.out.println(this.weight);
        this.weight = 1.5;
    }

    public static void main(String[] args) {

        /**
         * 	执行非静态代码块
         执行构造器....
         VarInstanceTime[name=xiao,age=12,weight=3.0]
         */
        VarInstanceTime instanceTime = new VarInstanceTime("xiao", 12);

        System.out.println(instanceTime.toString());

        VarInstanceTime instanceTime2 = new VarInstanceTime("xiao", 12);


    }

    @Override
    public String toString() {
        return "VarInstanceTime[name=" + name + ",age=" + age + ",weight=" + weight + "]";
    }

}
