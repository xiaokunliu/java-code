package com.xiaokunliu.study.springboot_j2ee.spring.topic.scheduled;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by keithl on 2017/11/8.
 */
@Configuration
@ComponentScan("com.xiaokunliu.study.springboot_j2ee.spring.topic.scheduled")
@EnableScheduling       // 开启对计划任务的支持
public class ScheduledTaskConfig {
}
