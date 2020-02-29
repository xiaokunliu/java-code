package com.xiaokunliu.j2se.javase.net.tcp.transText;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerText2 {

    public static void main(String[] args) throws IOException {

        //建立服务器端的端点
        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务器启动......");
        //接收多个客户端的对象
        while (true) {
            Socket c = server.accept();
            System.out.println(c.getInetAddress().getHostAddress() + "connect.........");
            new Thread(new ServerThread(c)).start();
        }

    }
}
