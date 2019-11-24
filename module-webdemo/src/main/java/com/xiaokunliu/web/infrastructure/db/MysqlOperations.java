package com.xiaokunliu.web.infrastructure.db;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * date:2019/11/22 21:30
 * author:keithl
 * desc: business desc etc.
 */
public class MysqlOperations<T> implements CRUDRepository<T> {

    private static Logger LOG = LoggerFactory.getLogger(MysqlOperations.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Class<T> entityClass;

    private String tableName;

    public MysqlOperations() {
        initParameters();
    }

    private void initParameters() {
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        this.tableName = this.entityClass.getAnnotation(DBTable.class).name();
    }

    @Override
    public int addEntity(T entity) throws Exception {
        StringBuilder sql = new StringBuilder();
        fullAddSql(sql);
        Field[] fields = entityClass.getDeclaredFields();
        List<Object> params = Lists.newArrayList();
        sql.append("(");
        for (Field field : fields) {
            if (field.getAnnotation(AutoId.class) == null) {
                field.setAccessible(true);
                // check field
                checkColumnField(field, entity);
                // add field
                params.add(field.get(entity));
                sql.append("?").append(",");
            }
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(")");
        LOG.debug("addEntity for SQL:" + sql.toString());
        return jdbcTemplate.update(sql.toString(), params.toArray());
    }

    @Override
    public int batchAddEntity(List<T> entityList) throws Exception {
        StringBuilder sql = new StringBuilder();
        fullAddSql(sql);
        Field[] fields = entityClass.getDeclaredFields();
        List<Object> params = Lists.newArrayList();
        for (T entity : entityList) {
            sql.append("(");
            for (Field field : fields) {
                if (field.getAnnotation(AutoId.class) == null) {
                    field.setAccessible(true);
                    // check field
                    checkColumnField(field, entity);
                    // add field
                    sql.append("?").append(",");
                    params.add(field.get(entity));
                }
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append(")").append(",");
        }
        sql.deleteCharAt(sql.length() - 1);
        LOG.debug("batchAddEntity for SQL:" + sql.toString());
        // 实际只发送一条sql语句
        return jdbcTemplate.update(sql.toString(), params.toArray()) > 0 ? entityList.size() : 0;
    }

    @Override
    public int updateById(Serializable id, T modifiedEntity) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE").append(" ").append(tableName).append(" ").append("SET").append(" ");
        Field[] fields = entityClass.getDeclaredFields();
        String idName = null;
        List<Object> params = Lists.newArrayList();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getAnnotation(DBColumn.class).name();
            if (field.getAnnotation(AutoId.class) != null) {
                idName = name;
                continue;
            }
            // check field
            checkColumnField(field, modifiedEntity);
            //set field
            if (field.getAnnotation(AutoId.class) == null && field.get(modifiedEntity) != null) {
                sql.append(name).append("=").append("?").append(",");
                params.add(field.get(modifiedEntity));
            }
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" ").append("WHERE").append(" ").append(idName).append("=").append("?");
        params.add(id);
        LOG.debug("updateById for SQL:" + sql.toString());
        return jdbcTemplate.update(sql.toString(), params.toArray());
    }

    @Override
    public int deleteById(Serializable id) {
        StringBuilder sql = new StringBuilder();
        String idName = fullDeleteSql(sql);
        sql.append(idName).append("=").append("?");
        LOG.debug("deleteById for SQL:" + sql.toString());
        return jdbcTemplate.update(sql.toString(), id);
    }

    @Override
    public int batchDelete(List<Serializable> ids) {
        StringBuilder sql = new StringBuilder();
        String idName = fullDeleteSql(sql);
        sql.append(idName).append(" ").append("IN");
        sql.append(" ").append("(");
        List<Object> params = Lists.newArrayList();
        for (Serializable id : ids) {
            sql.append("?").append(",");
            params.add(id);
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(")");
        LOG.debug("batchDelete for SQL:" + sql.toString());
        return jdbcTemplate.update(sql.toString(), params.toArray());
    }

    @Override
    public T queryById(Serializable id) {
        StringBuilder sql = new StringBuilder();
        String idName = fullQuerySql(sql);
        sql.append(idName).append("=").append("?");
        LOG.debug("queryById for SQL:" + sql.toString());
        return jdbcTemplate.queryForObject(sql.toString(), new RowMapper<T>() {
            @Override
            public T mapRow(ResultSet rs, int rowNum) {
                return resultSetToEntity(rs);
            }
        }, id);
    }

    @Override
    public List<T> queryLimited(long maxId, int limited) {
        StringBuilder sql = new StringBuilder();
        String idName = fullQuerySql(sql);
        sql.append(idName).append(">").append("?").append(" ").append("LIMIT").append(" ").append("?");
        LOG.debug("queryById for SQL:" + sql.toString());
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql.toString(), maxId, limited);
        return mapListToEntityList(mapList);
    }

    private void fullAddSql(StringBuilder sql) {
        sql.append("INSERT INTO").append(" ").append(tableName).append(" ");
        sql.append("(");
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(AutoId.class) == null) {
                field.setAccessible(true);
                String name = field.getAnnotation(DBColumn.class).name();
                sql.append(name).append(",");
            }
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(")");
        sql.append(" ").append("VALUES").append(" ");
    }

    private String fullQuerySql(StringBuilder sql) {
        Field[] fields = entityClass.getDeclaredFields();
        String idName = null;
        sql.append("SELECT").append(" ");
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getAnnotation(DBColumn.class).name();
            if (field.getAnnotation(AutoId.class) != null) {
                idName = name;
            }
            sql.append(name).append(",");
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" ").append("FROM").append(" ").append(tableName).append(" ").append("WHERE").append(" ");
        return idName;
    }

    private String fullDeleteSql(StringBuilder sql) {
        Field[] fields = entityClass.getDeclaredFields();
        String idName = null;
        for (Field field : fields) {
            if (field.getAnnotation(AutoId.class) != null) {
                idName = field.getAnnotation(DBColumn.class).name();
                break;
            }
        }
        sql.append("DELETE FROM").append(" ").append(tableName).append(" ").append("WHERE").append(" ");
        return idName;
    }

    protected T resultSetToEntity(ResultSet rs) {
        try {
            T instance = entityClass.newInstance();
            Field[] fields = entityClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String name = field.getAnnotation(DBColumn.class).name();
                field.set(instance, rs.getObject(name));
            }
            return instance;
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
        }
        return null;
    }

    protected List<T> mapListToEntityList(List<Map<String, Object>> mapList) {
        try {
            List<T> list = Lists.newArrayList();
            for (Map<String, Object> map : mapList) {
                T instance = entityClass.newInstance();
                Field[] fields = entityClass.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String name = field.getAnnotation(DBColumn.class).name();
                    field.set(instance, map.get(name));
                }
                list.add(instance);
            }
            return list;
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
        }
        return null;
    }

    private void checkColumnField(Field field, T entity) throws IllegalAccessException {
        Object value = field.get(entity);
        if (field.getType() == String.class && value != null) {
            String val = (String) value;
            int len = field.getAnnotation(DBColumn.class).len();
            if (val.length() > len) {
                throw new IllegalArgumentException(String.format("the field[%s]  have over limited[%s]", field.getName(), len));
            }
        }
    }
}
