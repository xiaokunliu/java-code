package com.xiaokunliu.commons.db;

import com.google.common.collect.Maps;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;

public class DBOperator extends DBSupport {

    private final static Logger LOG = LoggerFactory.getLogger(DBOperator.class);

    //could support the transaction,cause it is single class,have the same connection
    public static DBOperator getDBOperatorInstance() {
        return SingleDBOprHolder.DB_OPERATOR;
    }

    public Integer queryForInt(String sql) {
        return super.count(sql, new Object[]{});
    }

    public Integer queryForInt(String sql, Object[] params) {
        return super.count(sql, params);
    }

    public Float queryForFloat(String sql) {
        return queryForFloat(sql, new Object[]{});
    }

    public Float queryForFloat(String sql, Object[] params) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();

            if (null == rs) return null;

            if (rs.next()) return rs.getFloat(1);
            return null;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        } finally {
            LOG.info(pstmt + "");
            this.closeAll(rs, pstmt);
        }
    }

    public String queryForString(String sql) {
        return queryForString(sql, new Object[]{});
    }

    public String queryForString(String sql, Object[] params) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();

            if (null == rs) return null;

            if (rs.next()) return rs.getString(1);
            return null;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        } finally {
            LOG.info(pstmt + "");
            this.closeAll(rs, pstmt);
        }
    }

    private <T> T queryForObject(ResultSet rs, Class<T> clazz) throws Exception {
        ConvertUtils.register(new DateConverter(null), java.util.Date.class);
        ResultSetMetaData metaData = rs.getMetaData();
        if (rs.next()) {
            T newInstance = clazz.newInstance();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnLabel(i + 1);
                //String colomnTypeName = metaData.getColumnTypeName(i + 1);
                Object value = rs.getObject(columnName);
                if (null != value) BeanUtils.copyProperty(newInstance, columnName, value);
            }
            return newInstance;
        }
        return null;
    }

    public <T> T queryForObject(String sql, Class<T> clazz) {
        return queryForObject(sql, new Object[]{}, clazz);
    }

    public <T> T queryForObject(String sql, Object[] params, Class<T> clazz) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();

            if (null == rs) return null;

            return queryForObject(rs, clazz);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        } finally {
            LOG.info(pstmt + "");
            this.closeAll(rs, pstmt);
        }
    }

    public Map<String, Object> queryForMap(String sql) {
        return queryForMap(sql, new Object[]{});
    }

    public Map<String, Object> queryForMap(String sql, Object[] params) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();

            if (null == rs) return null;

            return wrapMap(rs);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        } finally {
            LOG.info(pstmt + "");
            this.closeAll(rs, pstmt);
        }
    }

    private Map<String, Object> wrapMap(ResultSet rs) throws Exception {
        ResultSetMetaData metaData = rs.getMetaData();
        if (rs.next()) {
            Map<String, Object> newInstance = new HashMap<String, Object>();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnLabel(i + 1);
                int sqlType = metaData.getColumnType(i + 1);
                if (sqlType == Types.TIMESTAMP) {
                    try {
                        newInstance.put(columnName, rs.getObject(columnName));
                    } catch (Exception e) {
                        LOG.error(e.getMessage());//'0000-00-00 00:00:00' from column 9 to TIMESTAMP. the database timestamp value is empty,could not get data from db,a little bad code,have to fix first
                        newInstance.put(columnName, "");
                    }
                } else {
                    newInstance.put(columnName, rs.getObject(columnName));
                }
            }
            return newInstance;
        }
        return null;
    }

    public Map<String, Map<String, Object>> queryForMap(String sql, String keyField) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (null == rs) return Maps.newHashMap();

            return queryForMapWithKey(rs, keyField);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Maps.newHashMap();
        } finally {
            LOG.info(pstmt + "");
            this.closeAll(rs, pstmt);
        }
    }

    private Map<String, Map<String, Object>> queryForMapWithKey(ResultSet rs, String keyField) throws Exception {
        Map<String, Map<String, Object>> result = Maps.newHashMap();
        ResultSetMetaData metaData = rs.getMetaData();
        while (rs.next()) {
            Map<String, Object> newInstance = new HashMap<String, Object>();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnLabel(i + 1);
                newInstance.put(columnName, rs.getObject(columnName));
            }
            result.put(rs.getString(keyField), newInstance);
        }
        return result;
    }

    public <T> List<T> queryForList(String sql, Class<T> clazz) {
        return queryForList(sql, new Object[]{}, clazz);
    }

    public <T> List<T> queryForList(String sql, Object[] params, Class<T> clazz) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();

            if (null == rs) return Collections.emptyList();

            return warpList(rs, clazz);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Collections.emptyList();
        } finally {
            LOG.info(pstmt + "");
            this.closeAll(rs, pstmt);
        }
    }

    private <T> List<T> warpList(ResultSet rs, Class<T> clazz) throws Exception {
        ConvertUtils.register(new DateConverter(null), java.util.Date.class);
        List<T> resultList = new ArrayList<T>();
        ResultSetMetaData metaData = rs.getMetaData();
        while (rs.next()) {
            T newInstance = clazz.newInstance();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnLabel(i + 1);
                Object value = rs.getObject(columnName);
                BeanUtils.copyProperty(newInstance, columnName, value);
            }
            resultList.add(newInstance);
        }
        return resultList;
    }

    public List<Map<String, Object>> queryForList(String sql) {
        return queryForList(sql, new Object[]{});
    }

    public List<Map<String, Object>> queryForList(String sql, Object[] params) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();

            if (null == rs) return Collections.emptyList();
            return warpList(rs);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Collections.emptyList();
        } finally {
            LOG.info(pstmt + "");
            this.closeAll(rs, pstmt);
        }
    }

    private List<Map<String, Object>> warpList(ResultSet rs) throws Exception {
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        ResultSetMetaData metaData = rs.getMetaData();
        while (rs.next()) {
            Map<String, Object> newInstance = new HashMap<String, Object>();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnLabel(i + 1);
                newInstance.put(columnName, rs.getObject(columnName));
            }
            resultList.add(newInstance);
        }
        return resultList;
    }

    public <T> List<T> queryForSingleFieldList(String sql, Class<T> clazz) {
        return queryForSingleFieldList(sql, new Object[]{}, clazz);
    }

    public <T> List<T> queryForSingleFieldList(String sql, Object[] params, Class<T> clazz) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();

            if (null == rs) return Collections.emptyList();
            return queryForTList(rs, clazz);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Collections.emptyList();
        } finally {
            LOG.info(pstmt + "");
            this.closeAll(rs, pstmt);
        }
    }

    private <T> List<T> queryForTList(ResultSet rs, Class<T> clazz) throws Exception {
        List<T> resultList = new ArrayList<T>();
        while (rs.next()) {
            T v = (T) rs.getObject(1);
            resultList.add(v);
        }
        return resultList;
    }

    public <T> T query4Update(String sql, Class<T> clazz, RowUpdate rowUpdate) {
        return query4Update(sql, new Object[]{}, clazz, rowUpdate);
    }

    public <T> T query4UpdateWithTran(String sql, Class<T> clazz, RowUpdate rowUpdate, Connection conn) {
        return query4UpdateWithTran(sql, new Object[]{}, clazz, rowUpdate, conn);
    }

    public <T> T query4Update(String sql, Object[] params, Class<T> clazz, RowUpdate rowUpdate) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();

            if (null == rs) return null;
            if (rs.next()) {
                rowUpdate.reply(rs);
                rs.updateRow();
            }
            rs.beforeFirst();
            return this.queryForObject(rs, clazz);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            LOG.info(pstmt + "");
            this.closeAll(rs, pstmt);
        }
        return null;
    }

    public <T> T query4UpdateWithTran(String sql, Object[] params, Class<T> clazz, RowUpdate rowUpdate, Connection conn) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            if (conn == null) {
                throw new Exception("the connection is null ");
            }
            pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();

            if (null == rs) return null;
            if (rs.next()) {
                rowUpdate.reply(rs);
                rs.updateRow();
            }
            rs.beforeFirst();
            return this.queryForObject(rs, clazz);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            LOG.info(pstmt + "");
            this.closeAll(rs, pstmt);
        }
        return null;
    }

    private static class SingleDBOprHolder {
        private static final DBOperator DB_OPERATOR = new DBOperator();
    }
}
