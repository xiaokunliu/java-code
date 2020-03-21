package com.xiaokunliu.interview.j2se.javase.net.tcp.transText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

    private Socket client;

    public ServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            // 接收从客户端发送过来的数据，纯文本数据，使用字符流
            BufferedReader brIn = new BufferedReader(new InputStreamReader(
                    client.getInputStream()));
            // 建立服务器发送数据对象
            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);// 自动刷新缓冲区的数据
            String text = null;
            while ((text = brIn.readLine()) != null) {
                if ("over".equals(text))
                    break;
                // 将数据显示在控制台上
                System.out.println(text);
                // 并且转换后的数据发送回客户端,如果没有换行，客户端在接收数据时将处于阻塞状态
                pw.println(text.toUpperCase());
            }
        } catch (IOException e) {


        } finally {
            try {
                if (client != null)
                    client.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
