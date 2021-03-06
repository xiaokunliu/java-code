package com.xiaokunliu.study.springboot_j2ee.spring.core.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by keithl on 2017/11/8.
 */
@Configuration
@ComponentScan("com.xiaokunliu.study.springboot_j2ee.spring.core.bean")
public class BeanConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public BeanWayService beanWayService(){
        return new BeanWayService();
    }

    @Bean
    public JSR250WayService jsr250WayService(){
        return new JSR250WayService();
    }
}
