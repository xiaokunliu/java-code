package com.xiaokunliu.j2se.javase.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {

    public static void main(String[] args) throws IOException {

        //创建服务器端的对象并且需要指定端口号
        ServerSocket server = new ServerSocket(10002);

        //获取客户端与服务器建立连接的对象
        Socket client = server.accept();
        //从客户端中获取流对象，并且读取数据，服务器读取客户端发送的数据
        InputStream in = client.getInputStream();

        //获取数据
        byte[] buf = new byte[1024];
        int len = 0;
        len = in.read(buf);

        String text = new String(buf, 0, len);
        System.out.println(client.getInetAddress().getHostAddress() + "send--->" + text);

        //向客户端写数据
        client.getOutputStream().write("收到".getBytes());

        //必须关闭客户端的资源，一般服务器不关闭
        client.close();
//		server.close();


    }
}
