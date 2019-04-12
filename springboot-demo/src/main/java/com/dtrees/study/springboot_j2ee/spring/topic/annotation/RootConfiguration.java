package com.dtrees.study.springboot_j2ee.spring.topic.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Created by keithl on 2017/11/8.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
public @interface RootConfiguration {

    /**
     * 以下两个注解称为元注解
     *  @Configuration
        @ComponentScan
     */

    // RootConfiguration 称为组合注解

    // 覆盖value参数
    String[] value() default {};
}
