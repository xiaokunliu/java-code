package com.xiaokunliu.study.springboot_j2ee.spring.topic.scheduled;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by keithl on 2017/11/8.
 */

public class ScheduledApplication {

    public static void main(String[] args) {
        /**
         * 以DEBUG的时候会出现以下错误,但是不影响程序正常使用
         *  No qualifying bean of type 'org.springframework.scheduling.TaskScheduler' available
         *
         *  改变日志输出级别即可
         *  log4j.logger.org.springframework.scheduling=INFO,配置文件没有生效,TODO
         */
        new AnnotationConfigApplicationContext(ScheduledTaskConfig.class);
    }
}
