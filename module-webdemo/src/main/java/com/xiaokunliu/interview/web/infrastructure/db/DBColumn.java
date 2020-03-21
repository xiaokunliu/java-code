package com.xiaokunliu.interview.web.infrastructure.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * date:2019/11/22 22:08
 * author:keithl
 * desc: business desc etc.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DBColumn {

    /**
     * db column name
     *
     * @return
     */
    String name() default "";

    /**
     * 字符串默认长度：255
     *
     * @return
     */
    int len() default 255;
}
