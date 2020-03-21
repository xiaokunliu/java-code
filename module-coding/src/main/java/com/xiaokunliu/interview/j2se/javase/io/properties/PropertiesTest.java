package com.xiaokunliu.interview.j2se.javase.io.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * 定义功能，获取一个应用程序运行的次数，如果超过5次，给出使用次数已到请注册的提示。并不要在运行程序。
 *
 * 思路：
 * 1，应该有计数器。
 * 每次程序启动都需要计数一次,并且是在原有的次数上进行计数。
 * 2，计数器就是一个变量。 突然冒出一想法，程序启动时候进行计数，计数器必须存在于内存并进行运算。
 * 可是程序一结束，计数器消失了。那么再次启动该程序，计数器又重新被初始化了。
 * 而我们需要多次启动同一个应用程序，使用的是同一个计数器。
 * 这就需要计数器的生命周期变长，从内存存储到硬盘文件中。
 *
 * 3,如何使用这个计数器呢？
 * 	首先，程序启动时，应该先读取这个用于记录计数器信息的配置文件。
 *  获取上一次计数器次数。 并进行试用次数的判断。
 *  其次，对该次数进行自增，并自增后的次数重新存储到配置文件中。
 *
 *
 * 4，文件中的信息该如何进行存储并体现。
 * 	直接存储次数值可以，但是不明确该数据的含义。 所以起名字就变得很重要。
 * 	这就有了名字和值的对应，所以可以使用键值对。
 * 	可是映射关系map集合搞定，又需要读取硬盘上的数据，所以map+io = Properties.
 *
 */
public class PropertiesTest {

    public static void main(String[] args) throws IOException {

        getProgramCount();
    }

    public static void getProgramCount() throws IOException {

        File file = new File(".//src//com//wind//io//properties//count.properties");
        //先判断文件是否存在
        if (!file.exists()) {
            //文件不存在
            file.createNewFile();
        }

        FileInputStream fis = new FileInputStream(file);
        Properties pro = new Properties();

        pro.load(fis);

        int count = 0;
        String value = pro.getProperty("count");
        if (value != null) {
            count = Integer.parseInt(value);
            if (count >= 5)
                throw new RuntimeException("使用该软件已超过次数，请注册....");
        }
        count++;
        System.out.println("欢迎...您还可以使用" + (5 - count) + "次");
        pro.setProperty("count", count + "");


        //将数据存放到配置文件中
        FileOutputStream fos = new FileOutputStream(file);
        pro.store(fos, "modify");


        fos.close();
        fis.close();
    }
}
