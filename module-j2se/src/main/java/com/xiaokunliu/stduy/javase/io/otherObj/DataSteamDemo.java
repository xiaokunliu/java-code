package com.xiaokunliu.stduy.javase.io.otherObj;

import java.io.*;

public class DataSteamDemo {

    /*
     * 操作Java的基本数据类型的流
     * byte/short/int/long/float/double/boolean
     * 还有一个字符串String
     */

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

//		writeData();
        readData();

    }

    public static void readData() throws IOException {

        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        //对写入的流进行按照UTF-8指定的读取
        String str = dis.readUTF();

        System.out.println(str);
    }

    public static void writeData() throws IOException {

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

        //使用指定的UTF-写进去，只有使用该流的读取对象才能够获取
        dos.writeUTF("你好");

        dos.close();


    }
}
