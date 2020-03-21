package com.xiaokunliu.interview.j2se.io.netty.base;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {

    public static void main(String[] args) {

        EventLoopGroup workgroup = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(workgroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc) {
                        sc.pipeline().addLast(new ClientHandler());
                    }
                });

        ChannelFuture cf1 = b.connect("127.0.0.1", 8765).sync();

        //buf	一边写,一边刷
        cf1.channel().writeAndFlush(Unpooled.copiedBuffer("777".getBytes()));

        cf1.channel().closeFuture().sync();
        workgroup.shutdownGracefully();

    }
}
