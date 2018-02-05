package com.dtrees.study.spring.topic.mutil_thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by keithl on 2017/11/8.
 */

@Service
public class AsyncService {

    @Async      // 表示该方法是异步方法,如果注解在类级别,表示类下的所有方法都是异步方法,这里的方法自动注入使用ThreadPoolTaskExecutor
    public void executeAsyncTask(int counter){
        System.out.println(String.format("execute executeAsyncTask for counter[%d]",counter));

    }

    @Async
    public void executeAsyncTaskPlus(int counter){
        System.out.println(String.format("execute executeAsyncTaskPlus for counter[%d]",counter));
    }
}
