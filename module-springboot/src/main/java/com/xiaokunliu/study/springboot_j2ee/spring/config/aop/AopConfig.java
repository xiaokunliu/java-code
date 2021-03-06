package com.xiaokunliu.study.springboot_j2ee.spring.config.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by keithl on 2017/11/8.
 */
@Configuration
@ComponentScan("com.xiaokunliu.study.springboot_j2ee.spring.config.aop")
@EnableAspectJAutoProxy     // 注解开启Spring对AspectJ的支持
public class AopConfig {
}
