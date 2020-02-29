package com.xiaokunliu.j2se.javase.net.tcp.upload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientImage {

    public static void main(String[] args) throws IOException {

        Socket client = new Socket("localhost", 10099);
        //获取源的数据
        FileInputStream fis = new FileInputStream("E:\\study\\itcastSE_Note\\day15\\image\\client.bmp");
        //向服务器发送图片数据
        OutputStream out = client.getOutputStream();

        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            out.write(buf, 0, len);
        }

        //告诉服务器已经传输完毕
        client.shutdownOutput();

        //接收从服务器反馈回来的消息
        InputStream in = client.getInputStream();
        int l = in.read(buf);
        String text = new String(buf, 0, l);

        System.out.println(text);


        fis.close();
        client.close();
    }
}
