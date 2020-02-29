package com.xiaokunliu.j2se.javase.io.otherObj;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayStreamDemo {

    /*
     * 操作源和目的设备为内存的流
     * ByteArrayInputStream、ByteArrayOutputStream
     * CharArrayReader、CharArrayWriter
     * StringReader、StringWriter
     * 特点：无需关闭流
     */

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) {

        ByteArrayInputStream bis = new ByteArrayInputStream("abcedf".getBytes());

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        //其他的内存流与字节数组流一样
        int ch = 0;

        while ((ch = bis.read()) != -1) {
            bos.write(ch);
        }

        System.out.println(bos.toString());
    }


}
