package com.dtrees.study.spring.config.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
