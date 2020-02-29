package com.xiaokunliu.j2se.javase.net.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendData implements Runnable {

    private DatagramSocket ds;

    public SendData(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String data = null;
            while ((data = br.readLine()) != null) {
                if ("over".equals(data))
                    break;
                byte[] buf = data.getBytes();
                //建立数据包,将数据封装在数据包中
                DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 10101);
                //发送数据
                ds.send(dp);
            }
            //关闭资源
            ds.close();
        } catch (IOException e) {

        }
    }

}
