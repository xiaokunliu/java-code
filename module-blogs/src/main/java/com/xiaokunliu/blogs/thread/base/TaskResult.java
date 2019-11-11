package com.xiaokunliu.blogs.thread.base;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * project:java-code
 * file:TaskResult
 * package:com.xiaokunliu.blogs.thread.base
 * date:2019/9/25 10:24
 * author:keithl
 */
public class TaskResult implements Callable<String> {

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        return "name: " + Thread.currentThread().getName() + " is using callable thread ....";
    }
}
