package com.xiaokunliu.web.infrastructure.db;

import java.io.Serializable;
import java.util.List;

/**
 * date:2019/11/22 21:16
 * author:keithl
 * desc: business desc etc.
 */
public interface CRUDRepository<T> {

    /**
     * 添加操作
     *
     * @param entity
     * @return
     */
    int addEntity(T entity) throws Exception;

    /**
     * 批量添加
     *
     * @param entityList
     * @return
     */
    int batchAddEntity(List<T> entityList) throws Exception;

    /**
     * 根据id进行更新
     *
     * @param id
     * @param modifiedEntity
     * @return
     */
    int updateById(Serializable id, T modifiedEntity) throws Exception;

    /**
     * 根据id进行删除
     *
     * @param id
     * @return
     */
    int deleteById(Serializable id) throws Exception;

    /**
     * 根据ids批量删除
     *
     * @param ids
     * @return
     */
    int batchDelete(List<Serializable> ids) throws Exception;

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    T queryById(Serializable id) throws Exception;

    /**
     * 分页查询
     *
     * @param maxId，必须是整数id
     * @param limited
     * @return
     */
    List<T> queryLimited(long maxId, int limited) throws Exception;

}
