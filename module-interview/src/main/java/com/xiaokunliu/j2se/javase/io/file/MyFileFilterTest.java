package com.xiaokunliu.j2se.javase.io.file;

import java.io.File;

public class MyFileFilterTest {

    public static void main(String[] args) {

        /*
         * 通过文件过滤器来查找指定目录下的jar包
         */
        File file = new File("E:\\tools\\jar包\\j2ee-jar与插件");
        File[] files = file.listFiles(new MyFileFilter(".jar"));
        for (File f : files) {
            System.out.println(f.getName());
        }


    }
}
