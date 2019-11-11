package com.xiaokunliu.blogs.thread.disruptor.generate2;


import com.lmax.disruptor.EventHandler;
import com.xiaokunliu.blogs.thread.disruptor.generate1.Trade;

public class Handler3 implements EventHandler<Trade> {
    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) {
    	System.out.println("handler3: name: " + event.getName() + " , price: " + event.getPrice() + ";  instance: " + event.toString());
    }  
}
