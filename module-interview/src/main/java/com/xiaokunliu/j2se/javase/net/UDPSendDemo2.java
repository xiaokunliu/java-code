package com.xiaokunliu.j2se.javase.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo2 {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        //建立UDP的发送端
        System.out.println("UDP发送到启动......");
        DatagramSocket ds = new DatagramSocket();
        //准备数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = null;
        while ((data = br.readLine()) != null) {
            byte[] buf = data.getBytes();
            //建立数据包,将数据封装在数据包中
            DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 10101);
            //发送数据
            ds.send(dp);
        }

        //关闭资源
        ds.close();


    }

}
