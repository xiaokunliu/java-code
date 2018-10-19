package com.books.concurrency_en.thread_management.factory;

import com.google.common.collect.Lists;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory{

    private int counter;
    private String name;
    private List<String> stats;

    public MyThreadFactory(String name) {
        this.name = name;
        this.counter = 0;
        stats = Lists.newArrayList();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t=new Thread(r,name+"-Thread_"+counter);
        counter++;
        stats.add(String.format("Created thread-Id %d with name %s on %s\n",t.getId(),t.getName(),new Date()));
        return t;
    }

    public String getStats() {
        StringBuffer buffer = new StringBuffer();
        for (String statsName:stats){
            buffer.append(statsName).append("\n");
        }
//        Iterator<String> it = stats.iterator();
//        while (it.hasNext()) {
//            buffer.append(it.next());
//            buffer.append("\n");
//        }
        return buffer.toString();
    }
}
