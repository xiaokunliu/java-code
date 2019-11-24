package com.xiaokunliu.web.infrastructure.db;

import java.io.Serializable;
import java.util.List;

/**
 * date:2019/11/22 21:28
 * author:keithl
 * desc: business desc etc.
 */
public class MySqlRepository<T> implements CRUDRepository<T> {

    @Override
    public int addEntity(T entity) {
        return 0;
    }

    @Override
    public int batchAddEntity(List<T> enityList) {
        return 0;
    }

    @Override
    public int updateById(Serializable id, T modifiedEntity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    @Override
    public int batchDelete(List<Serializable> ids) {
        return 0;
    }

    @Override
    public T queryById(Serializable id) {
        return null;
    }

    @Override
    public List<T> queryLimited(long maxId, int limited) {
        return null;
    }


}
