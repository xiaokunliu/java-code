package com.xiaokunliu.interview.web.infrastructure.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * date:2019/11/22 22:15
 * author:keithl
 * desc: business desc etc.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoId {

    // TODO define the annotation 
}
