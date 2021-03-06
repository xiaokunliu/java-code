package com.xiaokunliu.study.springboot_j2ee.spring.config.aop;

import java.lang.annotation.*;

/**
 * Created by keithl on 2017/11/8.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {

    String name();
//    注解本身是没有功能的,和xml一样,注解和xml都是属于一种元数据,即解释数据的数据,这就是所谓的配置
}
