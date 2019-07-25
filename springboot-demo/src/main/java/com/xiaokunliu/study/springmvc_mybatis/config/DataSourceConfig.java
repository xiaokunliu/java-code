package com.xiaokunliu.study.springmvc_mybatis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * project:java-code
 * file:DataSourceConfig
 * package:com.xiaokunliu.study.springmvc_mybatis.config
 * date:2019/4/5 4:08 PM
 * author:keithl
 */
@Configuration
@ImportResource({"classpath:db/beans_datasource.xml"})
public class DataSourceConfig {
}
