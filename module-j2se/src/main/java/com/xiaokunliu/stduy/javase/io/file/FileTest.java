package com.xiaokunliu.stduy.javase.io.file;

import java.io.File;

public class FileTest {

    /*
     * 深度遍历文件
     */
    public static void main(String[] args) {

        File file = new File("E:\\风");

        findAllFiles(file, 0);

    }

    public static void findAllFiles(File file, int level) {

        File[] files = file.listFiles();
        System.out.println(getSpace(level) + file.getName());
        level++;
        for (File f : files) {
            if (f.isDirectory()) {
                findAllFiles(f, level);
            } else {
                System.out.println(getSpace(level) + f.getName());
            }

        }

    }

    public static String getSpace(int level) {

        StringBuilder sb = new StringBuilder();
        sb.append("|--");
        for (int i = 0; i < level; i++) {
            sb.insert(i, "   ");
        }
        return sb.toString();
    }
}
