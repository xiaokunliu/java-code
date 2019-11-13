package com.xiaokunliu.stduy.javase.io.writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

    //获取系统的换行符
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

//		demo_1();

        demo_2();

    }

    public static void demo_2() throws IOException {
        /*
         * 注意：flush与close的区别
         * 		flush刷新缓存区的数据，此时输出流还可以续读
         * 		close是关闭资源，此时输出流无法续读
         */
        FileWriter fw = new FileWriter("demo.txt", true);
        //此时文件没有写进
        fw.write(LINE_SEPARATOR + "dshdsj");

        //必须将缓存区的数据直接写入目的地,刷新缓存
        fw.flush();
        fw.close();
    }

    public static void demo_1() {
        //处理IO流的正确方式
        FileWriter fw = null;
        try {
            fw = new FileWriter("demo.txt");

            fw.write("dhijdiwdiwudi");


        } catch (IOException e) {
//			code....
            throw new RuntimeException("IO业务代码块异常");

        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
//					code....					
                    throw new RuntimeException("关闭异常");
                }
            }
        }
    }

}
