package com.xiaokunliu.stduy.javase.io.print;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {

    public static void main(String[] args) throws IOException {

        /*
         * PrintStream:
         * 1,提供了打印方法可以对多种数据类型值进行打印。并保持数据的表示形式。
         * 2，它不抛IOException.
         *
         * 构造函数，接收三种类型的值：
         * 1，字符串路径。
         * 2，File对象。
         * 3，字节输出流。
         */

        PrintStream out = new PrintStream(".//src//com//wind//io//print//print.txt");

//		int by = read();
//		write(by);

//		out.write(610);//只写最低8位，一个字节，如int有4个字节，仅仅读取最后的8位

//		out.print(97);//将97先变成字符保持原样将数据打印到目的地。 两个字节

        out.close();
    }
}
