package com.xiaokunliu.stduy.javase.io.otherObj;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        /*
         * RandomAccessFile
         * 一看这个类名字，纠结。不是io体系中的子类。
         *
         * 特点：
         * 1，该对象即能读，又能写。
         * 2，该对象内部维护了一个byte数组，并通过指针可以操作数组中的元素，
         * 3，可以通过getFilePointer方法获取指针的位置，和通过seek方法设置指针的位置。
         * 4，其实该对象就是将字节输入流和输出流进行了封装。
         * 5，该对象的源或者目的只能是文件。通过构造函数就可以看出。
         *
         *
         */

//		writeFile();
//		readFile();
        randomWrite();
    }

    public static void randomWrite() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("ranacc.txt", "rw");

        //往指定位置写入数据。
        raf.seek(3 * 8);

        raf.write("哈哈".getBytes());
        raf.writeInt(108);

        raf.close();
    }


    public static void readFile() throws IOException {

        RandomAccessFile raf = new RandomAccessFile("ranacc.txt", "r");

        //通过seek设置指针的位置。
        raf.seek(1 * 8);//随机的读取。只要指定指针的位置即可。

        byte[] buf = new byte[4];
        raf.read(buf);

        String name = new String(buf);

        int age = raf.readInt();

        System.out.println("name=" + name);
        System.out.println("age=" + age);

        System.out.println("pos:" + raf.getFilePointer());

        raf.close();


    }

    //使用RandomAccessFile对象写入一些人员信息，比如姓名和年龄。
    public static void writeFile() throws IOException {
		/*
		 * 如果文件不存在，则创建，如果文件存在，不创建
		 * 	RandomAccessFile(File file, String mode) 
		          	创建从中读取和向其中写入（可选）的随机访问文件流，该文件由 File 参数指定。 
			RandomAccessFile(String name, String mode) 
		          	创建从中读取和向其中写入（可选）的随机访问文件流，该文件具有指定名称。 
		     mode值含意
				"r"  以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。  
				"rw" 打开以便读取和写入。如果该文件尚不存在，则尝试创建该文件。  
				"rws"打开以便读取和写入，对于 "rw"，还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备。  
				"rwd"打开以便读取和写入，对于 "rw"，还要求对文件内容的每个更新都同步写入到底层存储设备。  
		 */
        RandomAccessFile raf = new RandomAccessFile("ranacc.txt", "rw");

        raf.write("张三".getBytes());
        raf.writeInt(97);
        raf.write("小强".getBytes());
        raf.writeInt(99);
//		
        raf.close();
    }

}
