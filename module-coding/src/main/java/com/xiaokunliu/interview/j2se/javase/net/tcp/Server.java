package com.xiaokunliu.interview.j2se.javase.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by keithl on 2017/9/3.
 */

public class Server {

    public static void main(String[] args) throws IOException {
        //创建服务器端的对象并且需要指定端口号
        ServerSocket server = new ServerSocket(10002);
        while (true) {
            //获取客户端与服务器建立连接的对象
            Socket client = server.accept();
            while (true) {
                try {
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
                } catch (Exception e) {
                    System.out.println(client.getInetAddress().getHostAddress() + "退出....");
                    client.close();
                    break;
                }
            }
        }

    }

}

