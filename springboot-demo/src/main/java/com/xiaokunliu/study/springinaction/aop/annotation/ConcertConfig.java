package com.xiaokunliu.study.springinaction.aop.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.xiaokunliu.study.springinaction.aop"})
public class ConcertConfig {

    @Bean
    public Audience audience(){
        return new Audience();
    }
}
