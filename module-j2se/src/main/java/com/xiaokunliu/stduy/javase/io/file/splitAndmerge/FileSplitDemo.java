package com.xiaokunliu.stduy.javase.io.file.splitAndmerge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileSplitDemo {


    private static final int SIZE = 1048576;//1024*1024===1M

    public static void main(String[] args) throws IOException {

        File source = new File("E:\\1.png");
        File dest = new File("E:\\partFile2");

        splitFile(source, dest);

    }

    public static void splitFile(File source, File dest) throws IOException {

        if (!dest.exists()) {
            dest.mkdirs();
        }
        FileInputStream fis = new FileInputStream(source);

        byte[] buf = new byte[SIZE];


        FileOutputStream out = null;
        int count = 1;
        int len = 0;
        while ((len = fis.read(buf)) != -1) {

            out = new FileOutputStream(new File(dest, (count++) + ".part"));
            out.write(buf, 0, len);
            out.close();
        }
        //将源文件的一些信息设置到配置文件中，方便进行合并数据需要
        Properties pro = new Properties();
        pro.setProperty("filename", source.getName());
        pro.setProperty("count", Integer.toString(count));

        //将数据到目的文件
        out = new FileOutputStream(new File(dest, count + ".properties"));

        pro.store(out, "saveInfo");

        out.close();
        fis.close();
    }

}
