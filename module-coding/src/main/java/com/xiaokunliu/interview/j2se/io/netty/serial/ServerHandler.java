package com.xiaokunliu.interview.j2se.io.netty.serial;

import com.xiaokunliu.interview.j2se.io.utils.GzipUtils;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.io.File;
import java.io.FileOutputStream;


public class ServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Req req = (Req) msg;
        System.out.println("Server : " + req.getId() + ", " + req.getName() + ", " + req.getRequestMessage());
        byte[] attachment = GzipUtils.ungzip(req.getAttachment());

        String path = System.getProperty("user.dir") + File.separatorChar + "receive" + File.separatorChar + "001.jpg";
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(attachment);
        fos.close();

        Resp resp = new Resp();
        resp.setId(req.getId());
        resp.setName("resp" + req.getId());
        resp.setResponseMessage("响应内容" + req.getId());
        ctx.writeAndFlush(resp);//.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }


}
