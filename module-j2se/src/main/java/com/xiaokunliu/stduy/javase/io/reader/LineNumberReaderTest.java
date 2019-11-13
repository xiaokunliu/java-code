package com.xiaokunliu.stduy.javase.io.reader;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderTest {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        LineNumberReader lnr = new LineNumberReader(new FileReader("system.txt"));

        String line = null;
        lnr.setLineNumber(100);
        while ((line = lnr.readLine()) != null) {

            System.out.println(lnr.getLineNumber() + ":" + line);
        }
        lnr.close();


    }

}
