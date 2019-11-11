package com.xiaokunliu.io.netty.helloworld;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.nio.charset.StandardCharsets;

public class ServerHandler extends ChannelHandlerAdapter {


	@Override
    public void channelActive(ChannelHandlerContext ctx) {
		System.out.println("server channel active... ");
	}


	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
			ByteBuf buf = (ByteBuf) msg;
			byte[] req = new byte[buf.readableBytes()];
			buf.readBytes(req);
        String body = new String(req, StandardCharsets.UTF_8);
			System.out.println("Server :" + body );
			String response = "进行返回给客户端的响应：" + body ;
			ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
			//.addListener(ChannelFutureListener.CLOSE);
	}

	@Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
		System.out.println("读完了");
		ctx.flush();
	}

	@Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable t) {
		ctx.close();
	}

}
