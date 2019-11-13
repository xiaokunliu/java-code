package com.xiaokunliu.stduy.javase.ObjectAPITest;

import java.util.Enumeration;

public class SystemTest {

    public static void main(String[] args) {
//		System:类中的方法和属性都是静态的。
//		systemCurrentTime();

//		getSystemProperty();

//		testSystemSperator();


    }

    public static void testSystemSperator() {
        //		file.separator 文件分隔符（在 UNIX 系统中是“/”）
        System.out.println("file.separator---" + System.getProperty("file.separator"));
        //		path.separator 路径分隔符（在 UNIX 系统中是“:”）
        System.out.println("path.separator--" + System.getProperty("path.separator"));
        //		line.separator 行分隔符（在 UNIX 系统中是“/n”）
        System.out.println("line.separator---" + System.getProperty("line.separator"));

        System.out.println("hello" + System.getProperty("line.separator") + "world");
    }

    public static void getSystemProperty() {
        //		static Properties getProperties()  确定当前的系统属性。
        //获得系统所有的属性
        Enumeration<String> names = (Enumeration<String>) System.getProperties().propertyNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(name + "-----" + System.getProperty(name));
        }
    }

    public static void systemCurrentTime() {
//		static long currentTimeMillis() 返回以毫秒为单位的当前时间。 
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
        long l2 = System.currentTimeMillis();
        System.out.println("spendTime:" + (l2 - l1));
    }
}
