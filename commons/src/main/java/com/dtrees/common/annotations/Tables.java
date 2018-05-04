package com.dtrees.common.annotations;

import java.lang.annotation.*;

/**
 * project:shop-wechat
 * file:Tables
 * package:com.dtrees.common.annotations
 * date:2018/3/25 下午3:41
 * author:keithl
 */
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Tables {

    /**
     * tableName
     * @return
     */
    String value();

}
