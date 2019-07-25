package com.xiaokunliu.common.file;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import com.google.common.collect.Lists;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Created by keithl on 2017/10/11.
 */

public final class CSVUtility {

    public static List<String[]> readFromCSVFile(String fileName){
        List<String[]> csvList = Lists.newArrayList();
        try {
            File file = new File(fileName);
            if(!file.exists()){
                throw new RuntimeException(String.format("the fileName %s is not exist", fileName));
            }
            if(!file.isFile()){
                throw new RuntimeException(String.format("the fileName %s is not a file", fileName));
            }
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] row = null;
            while((row=reader.readNext())!=null){
                csvList.add(row);
            }
            reader.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return csvList;
    }

    public static void writeToCSVFile(String fileName,List<String[]> msgList){
        File file = new File(fileName);
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            CSVWriter csvWriter = new CSVWriter(osw,',');
            csvWriter.writeAll(msgList);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
