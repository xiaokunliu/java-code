package com.xiaokunliu.interview.j2se.javase.net.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {

    public static void main(String[] args) throws IOException {
        //创建客户端对象，并且指定IP和端口
        Socket client = new Socket("localhost", 10002);

        //建立socket流，并且获取socket的流对象
        //客户端向服务器端发送数据
        OutputStream out = client.getOutputStream();

        //写数据
        out.write("中性点hi文化地位".getBytes());

        //关闭资源
        client.close();//out也已经关闭
    }
}
