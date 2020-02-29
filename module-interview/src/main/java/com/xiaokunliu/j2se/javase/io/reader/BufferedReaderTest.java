package com.xiaokunliu.j2se.javase.io.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {


        FileReader fd = new FileReader("demo.txt");

//		demo_1(fd);

//		demo_2(fd);
        demo_3(fd);

    }

    public static void demo_3(FileReader fd) throws IOException {
        BufferedReader br = new BufferedReader(fd);

        int len = 0;
        char[] buf = new char[1024];
        while ((len = br.read(buf)) != -1) {
            System.out.print(new String(buf, 0, len));
        }
        br.close();
    }

    public static void demo_2(FileReader fd) throws IOException {
        BufferedReader br = new BufferedReader(fd);


        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }


        br.close();
    }

    public static void demo_1(FileReader fd) throws IOException {
        BufferedReader br = new BufferedReader(fd);

        int ch = 0;
        while ((ch = br.read()) != -1) {
            System.out.print((char) ch);
        }

        br.close();
    }
}
