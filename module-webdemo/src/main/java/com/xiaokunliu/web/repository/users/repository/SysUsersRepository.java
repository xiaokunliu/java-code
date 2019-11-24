package com.xiaokunliu.web.repository.users.repository;

import com.xiaokunliu.web.infrastructure.db.CRUDRepository;
import com.xiaokunliu.web.repository.users.po.SysUsers;

import java.util.List;

/**
 * date:2019/11/22 21:07
 * author:keithl
 * desc: business desc etc.
 */
public interface SysUsersRepository extends CRUDRepository<SysUsers> {

    List<SysUsers> queryAllByDeptId(long deptId);

}
