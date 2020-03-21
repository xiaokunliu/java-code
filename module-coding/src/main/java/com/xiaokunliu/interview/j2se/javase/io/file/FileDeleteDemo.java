package com.xiaokunliu.interview.j2se.javase.io.file;

import java.io.File;

public class FileDeleteDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        File dir = new File("E:\\文件夹");

        removeDir(dir);

    }

    public static void removeDir(File dir) {


        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                removeDir(file);
            } else {
                System.out.println(file.getName() + ":" + file.delete());
            }
        }
        System.out.println(dir.getName() + ":" + dir.delete());


    }

}
