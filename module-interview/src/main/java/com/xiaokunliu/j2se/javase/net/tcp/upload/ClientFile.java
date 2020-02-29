package com.xiaokunliu.j2se.javase.net.tcp.upload;

import java.io.*;
import java.net.Socket;

/*
 * 上传纯文本的文件
 */
public class ClientFile {

    public static void main(String[] args) throws IOException {

        Socket client = new Socket("localhost", 9999);

        //获取本地客户端的
        BufferedReader br = new BufferedReader(new FileReader("d:\\client.txt"));
        //将数据发送到服务器，这次使用BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            //必须刷出缓冲区
            bw.flush();
        }

//		告诉服务器上传结束
        client.shutdownOutput();//这里如果没有告诉服务器，则两端将处于阻塞状态，因为客户端这边需要等待服务器接收的数据
        //即下面的readLine将处于阻塞状态

        //接收服务器获取文件的情况
//		接收服务器发送过来的数据
        BufferedReader brIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println(brIn.readLine());

        br.close();
        client.close();
    }
}
