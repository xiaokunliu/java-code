package com.xiaokunliu.study.springboot_j2ee.spring.topic.mutil_thread;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by keithl on 2017/11/8.
 */

public class AsyncApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncService asyncService = applicationContext.getBean(AsyncService.class);

        for (int i=0;i <=10;i++){
            asyncService.executeAsyncTask(i);
            asyncService.executeAsyncTaskPlus(i);
        }

        // 并发执行而非同步执行
    }
}
