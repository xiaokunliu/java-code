package com.xiaokunliu.study.springinaction.aop.xml;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * project:java-code
 * file:AopConfig
 * package:com.xiaokunliu.study.springinaction.aop.xml
 * date:2019/9/24 14:15
 * author:keithl
 */
@Configuration
@ImportResource(value = "classpath:spring/beans_aop.xml")
public class AopConfig {
}
