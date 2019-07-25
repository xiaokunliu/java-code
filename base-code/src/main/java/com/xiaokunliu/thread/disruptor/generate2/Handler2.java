package com.xiaokunliu.thread.disruptor.generate2;


import com.xiaokunliu.thread.disruptor.generate1.Trade;
import com.lmax.disruptor.EventHandler;

public class Handler2 implements EventHandler<Trade> {
	  
    @Override  
    public void onEvent(Trade event, long sequence,  boolean endOfBatch) throws Exception {  
    	System.out.println("handler2: set price");
    	event.setPrice(17.0);
    	Thread.sleep(1000);
    }  
      
}  