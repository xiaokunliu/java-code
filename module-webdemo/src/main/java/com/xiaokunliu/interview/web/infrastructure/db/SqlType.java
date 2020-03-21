package com.xiaokunliu.interview.web.infrastructure.db;

/**
 * date:2019/11/22 21:33
 * author:keithl
 * desc: business desc etc.
 */
public enum SqlType {

    /**
     * 添加操作
     */
    ADD,

    /**
     * 批量添加
     */
    BATCH_ADD,

    /**
     * 批量更新
     */
    UPDATE,

    /**
     * 删除
     */
    DELETE,

    /**
     * 批量删除
     */
    BATCH_DELETE,

    /**
     * 不带分页查询
     */
    QUERY,

    /**
     * 分页查询
     */
    QUERY_LIMITED,

}
