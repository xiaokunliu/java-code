package com.xiaokunliu.javase.io.obj;

import com.xiaokunliu.javase.bean.Stu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by keithl on 2017/9/3.
 */

public class TestObj {
    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;

    public static void main(String[] args) {

        String path = ".//src//com//wind//io//obj//obj.object";
        TestObj t = new TestObj();
        List<Stu> list = getStus();

        t.write(list, path);

        t.read(path);
    }

    public void read(String path) {
        // TODO Auto-generated method stub
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            while (true) {
                /*
                 * java.io.EOFException表明到达流的末尾，没有存在任何数据了
				 */
                try {
                    Stu s = (Stu) ois.readObject();
                    System.out.println(s);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public void write(List<Stu> list, String path) {

        try {
            File f = new File(path);
            if (f.length() <= 0) {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            } else {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            }
            for (Stu s : list) {
                oos.writeObject(s);
                oos.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null)
                try {
                    oos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

    }

    private static List<Stu> getStus() {

        List<Stu> list = new ArrayList<Stu>();
        for (int i = 10; i < 20; i++) {
            list.add(new Stu("xiao000" + i, i));
        }
        return list;
    }
}
