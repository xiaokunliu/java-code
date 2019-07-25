package com.xiaokunliu.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by keithl on 2017/9/28.
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.xiaokunliu.springmvc.core"})
public class RootConfig {

    // 注册一系列初始化beans

}
