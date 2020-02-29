package com.xiaokunliu.j2se.javase.io.otherObj;

import com.xiaokunliu.j2se.javase.bean.Stu;

import java.io.*;

/*
 * 写对象的流
 */
public class ObjectInputStreamDemo {

    /**
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//		writeObj();
        readObj();
    }

    public static void readObj() throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.object"));
        //对象的反序列化。
        Stu s = (Stu) ois.readObject();

        System.out.println(s.getName() + ":" + s.getAge());

        ois.close();

    }

    public static void writeObj() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.object"));
        //对象序列化。  被序列化的对象必须实现Serializable接口。
        oos.writeObject(new Stu("小强", 30));
        oos.close();

    }
}
