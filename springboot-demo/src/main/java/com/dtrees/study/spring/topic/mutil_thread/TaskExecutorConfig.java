package com.dtrees.study.spring.topic.mutil_thread;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by keithl on 2017/11/8.
 */
@Configuration
@ComponentScan("com.dtrees.study.spring.topic.mutil_thread")
@EnableAsync        // 开启异步任务支持
public class TaskExecutorConfig implements AsyncConfigurer{

    // 实现异步配置并重写getAsyncExecutor和getAsyncUncaughtExceptionHandler方法
    @Override
    public Executor getAsyncExecutor() {
        // 创建任务执行器线程池
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(10);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }


}
