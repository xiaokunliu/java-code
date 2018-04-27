package com.dtrees.common.annotations;

import java.lang.annotation.*;

/**
 * project:shop-wechat
 * file:Column
 * package:com.dtrees.common.annotations
 * date:2018/3/25 下午3:44
 * author:keithl
 */
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {

    /**
     * 数据表的字段名称
     * @return
     */
    String value();

}
