package com.xiaokunliu.study.springinaction.aop.aspectj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

/**
 * project:java-code
 * file:AspectJConfig
 * package:com.xiaokunliu.study.springinaction.aop.aspectj
 * date:2019/9/24 09:01
 * author:keithl
 */
@Configuration
@EnableSpringConfigured
@ComponentScan(basePackages = {"com.xiaokunliu.study.springinaction.aop.aspectj"})
@ImportResource(value = {"classpath:spring/beans_aop.xml"})
public class AspectJConfig {


}
