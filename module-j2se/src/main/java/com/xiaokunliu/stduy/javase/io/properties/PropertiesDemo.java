package com.xiaokunliu.stduy.javase.io.properties;

import java.io.*;
import java.util.Properties;

public class PropertiesDemo {

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {

//		demo_1();

//		demo_2();

//		demo_3();


//		demo_4();


        modifyData("username", "root");


    }


    public static void modifyData(String key, String value) throws IOException {
        /*
         * 读取这个文件。
         * 并将这个文件中的键值数据存储到集合中。
         * 在通过集合对数据进行修改。
         * 在通过流将修改后的数据存储到文件中。
         */
        Properties pro = new Properties();
        FileInputStream fis = new FileInputStream(".//src//com//wind//io//properties//info.properties");

        pro.load(fis);

        pro.setProperty(key, value);

        FileOutputStream out = new FileOutputStream(".//src//com//wind//io//properties//info.properties");

        pro.store(out, "info");

        out.close();
        fis.close();

    }


    //		//模拟一下load方法。
    public static void myLoad(InputStream in) throws IOException {

        Properties pro = new Properties();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while ((line = br.readLine()) != null) {

            if (line.startsWith("#"))
                continue;
            String[] arr = line.split("=");
            pro.setProperty(arr[0], arr[1]);

        }

        pro.list(System.out);
    }


    public static void demo_4() throws IOException {
        /*
         * 加载配置文件的数据
         */
        Properties pro = new Properties();

        FileInputStream fis = new FileInputStream(".//src//com//wind//io//properties//info.properties");

        pro.load(fis);
        pro.list(System.out);
        fis.close();
    }


    public static void demo_3() throws IOException {
        Properties pro = new Properties();

        //存储元素。
        pro.setProperty("driver", "com.mysql.jdbc.Driver");
        pro.setProperty("url", "jdbc:localhost:3306/test");
        pro.setProperty("username", "wind");
        pro.setProperty("pwd", "wind");

        //想要将这些集合中的字符串键值信息持久化存储到文件中。
        //需要关联输出流。
        FileOutputStream fos = new FileOutputStream(".//src//com//wind//io//properties//info.properties");

        //将集合中数据存储到文件中，使用store方法。
        pro.store(fos, "info");

        fos.close();
    }

    public static void demo_2() {
        //获取系统的所有属性
        Properties pro = System.getProperties();

        //显示所有系统属性的数据
        pro.list(System.out);
    }

    public static void demo_1() {
        /*
         * Properties集合的存和取。
         */
        Properties pro = new Properties();
        pro.setProperty("driver", "com.mysql.jdbc.Driver");
        pro.setProperty("url", "jdbc:localhost:3306/test");
        pro.setProperty("username", "wind");
        pro.setProperty("pwd", "wind");

        //设置值
        pro.setProperty("username", "root");
        //遍历
//		for(String key:pro.stringPropertyNames()){
//			String value=pro.getProperty(key);
//			System.out.println(key+":"+value);
//		}

        //快捷方法查看pro的所有属性
        pro.list(System.out);
    }

}
