package com.xiaokunliu.j2se.javase.net.tcp.upload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientData {

    /*
     * 多个用户发送数据
     */
    public static void main(String[] args) throws IOException {

        Socket client = new Socket("localhost", 9090);
        System.out.println("客户端开始访问.......");
        //获取数据
        String filePath = "E:\\study\\itcastSE_Note\\day15\\client.bmp";
        //读取数据
        FileInputStream fis = new FileInputStream(filePath);
        //将数据发送到服务器
        OutputStream out = client.getOutputStream();


        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        client.shutdownOutput();

        //接收从服务器发送过来的信息
        InputStream in = client.getInputStream();
        len = in.read(buf);
        System.out.println(new String(buf, 0, len));
        client.close();
    }

}

