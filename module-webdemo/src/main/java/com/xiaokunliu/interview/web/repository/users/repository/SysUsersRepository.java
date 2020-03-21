package com.xiaokunliu.interview.web.repository.users.repository;

import com.xiaokunliu.interview.web.infrastructure.db.CRUDRepository;
import com.xiaokunliu.interview.web.repository.users.po.SysUsers;

import java.util.List;

/**
 * date:2019/11/22 21:07
 * author:keithl
 * desc: business desc etc.
 */
public interface SysUsersRepository extends CRUDRepository<SysUsers> {

    List<SysUsers> queryAllByDeptId(long deptId);

}
