package com.xiaokunliu.interview.web.users.domain.user.repository;

import com.xiaokunliu.interview.web.infrastructure.db.MysqlOperations;
import com.xiaokunliu.interview.web.repository.users.po.SysUsers;
import com.xiaokunliu.interview.web.repository.users.repository.SysUsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * date:2019/11/23 00:01
 * author:keithl
 * desc: business desc etc.
 */
@Repository
public class SysUsersRepo extends MysqlOperations<SysUsers> implements SysUsersRepository {

    private static Logger LOG = LoggerFactory.getLogger(SysUsersRepo.class);

    @Override
    public List<SysUsers> queryAllByDeptId(long deptId) {
        StringBuilder sql = this.buildQuerySql();
        sql.append("AND").append(" ").append("dept_id").append("=").append("?");
        LOG.debug("queryAllByDeptId SQL:" + sql.toString());
        return this.queryForEntityList(sql.toString(), deptId);
    }
}
