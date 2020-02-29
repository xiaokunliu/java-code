package com.xiaokunliu.j2se.javase.net.chat;

import java.io.IOException;
import java.net.DatagramSocket;

public class ChatDemo {

    public static void main(String[] args) throws IOException {
        DatagramSocket send = new DatagramSocket();
        DatagramSocket receive = new DatagramSocket(10101);


        new Thread(new SendData(send)).start();
        new Thread(new ReceiveData(receive)).start();
    }
}
