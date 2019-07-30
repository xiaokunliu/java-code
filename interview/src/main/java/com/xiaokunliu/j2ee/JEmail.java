package com.xiaokunliu.j2ee;

/**
 * project:java-code
 * file:JEmail
 * package:com.xiaokunliu.j2ee
 * date:2018/10/3 下午8:44
 * author:keithl
 */
public class JEmail {

    /**
     * SMTP协议
     *      SMTP协议是基于文本的传输协议，在其上指定了一条消息的多个接收者，然后开始传输消息文本，可以很简单地通过telnet程序来测试一个SMTP服务器
     *      使用的TCP端口为25，要将一个域名定位到SMTP服务器，需要使用MX DNS
     * SMTP协议工作在两种情况下：
     *      1。电子有爱你从客户端传输到服务端
     *      2。是从某一个服务器传输到另一个服务器
     * SMTP是一个请求/响应协议，命令和响应是基于ASCII文本的，并以CR和LF符结束，响应包括一个表示返回状态的3位数字代码，协议的过程很简单，一个客户端向服务端发送命令，服务器向
     * 客户端返回一些信息，客户端发送的命令以及服务器的回应都是字符串，并不需要特别的软件就能独处它们
     *
     * POP3协议（邮局协议）
     *      适用于C/S架构的email协议，是一种传输协议，该协议定义如何将客户端连接到邮件服务器，并下载电子邮件，POP3是Internet电子邮件的第一个离线协议标准，它允许用户
     *      从服务器上把邮件存储到本地主机，同时删除保存在邮件服务器上的邮件，而POP3服务器则是遵循POP3协议的邮件接收服务器，用来接收并保存电子邮件
     *      POP3服务器程序通常是建立在TCP端口的110服务上，当客户需要使用该服务时，应先与服务器建立TCP连接，一旦建立TCP连接，POP3服务器向客户端发送一条欢迎消息，客户端
     *      开始给服务器发送命令，服务器者给出相应的回答
     *
     * POP3命令由一个关键词或者是关键词+参数组成，每个命令以回车换行（0xD0xA）作为结束标志，对于所有命令，POP3服务器都会提供一个回答，服务器的回答由一个状态标志+一些附加信息组成，
     * 目前使用的两个标志是"+OK"和"-ERR"，分别表示客户的命令是否合法，所有的回答也是以回车换行结束
     *
     * IMAP4协议（交互邮件访问协议）
     *      也是一个让本地邮件客户端访问远程服务器上的邮件的协议，IMAP4和POP3是目前邮件访问中使用最广泛的标准协议
     * 与POP3协议区别：
     *      1。在线方式，邮件信息保留在邮件服务器端，客户端可以对其进行查看，管理。其使用方式就像我们使用网页登录邮箱一样
     *      2。离线方式，邮件信息被下载到本地，邮件客户端可以对其进行管理，与POP3协议一样
     *      3。分离方式，邮件信息的一部分在邮件服务端，另一部分在邮件客户端，与IBM Lotus的工作方式有些类似
     */
}
