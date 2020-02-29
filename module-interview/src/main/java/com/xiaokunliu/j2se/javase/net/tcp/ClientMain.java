package com.xiaokunliu.j2se.javase.net.tcp;

import java.io.IOException;
import java.net.Socket;

public class ClientMain {

    public static void main(String[] args) throws IOException {
        //应该建立多个客户端
        Client client = new Client(new Socket("localhost", 10002));

        new Thread(client).start();

    }
}
