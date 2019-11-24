package com.xiaokunliu.web.infrastructure.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * date:2019/11/22 22:08
 * author:keithl
 * desc: business desc etc.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {

    /**
     * db table_name
     *
     * @return
     */
    String name() default "";

}
