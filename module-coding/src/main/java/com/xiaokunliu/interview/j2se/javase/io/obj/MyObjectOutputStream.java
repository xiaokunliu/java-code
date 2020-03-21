package com.xiaokunliu.interview.j2se.javase.io.obj;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/*
 * 要使用的对象文件已经存在，需要在已有的对象文件追加上去，必须将流重置
 * 重置将丢弃已写入流中的所有对象的状态。重新设置状态，使其与新的 ObjectOutputStream 相同。
 * 将流中的当前点标记为 reset，相应的 ObjectInputStream 也将在这一点重置。
 * 以前写入流中的对象不再被视为正位于流中。它们会再次被写入流。
 *
 * 重置的目的是将当前的对象数据和之前流写入的对象一起重新放置流中并全部写入文件中
 *
 * 构建子类的对象流目的就是要避免在读取对象流时再次读取到流写入文件的头信息而导致数据信息不一致而发生
 * StreamCorruptedException - 流中的控制信息不一致。
 * 改写头信息的目的是要将流重置，重置将会是读取流也重置到原来构建对象流的初始状态
 */
public class MyObjectOutputStream extends ObjectOutputStream {


    public MyObjectOutputStream() throws IOException, SecurityException {
        super();
    }

    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    public void writeStreamHeader() throws IOException {
        //必须将流重置
        super.reset();
        return;
    }

}
