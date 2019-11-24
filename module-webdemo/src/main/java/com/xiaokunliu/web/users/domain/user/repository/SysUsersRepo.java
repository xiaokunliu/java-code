package com.xiaokunliu.web.users.domain.user.repository;

import com.xiaokunliu.web.infrastructure.db.MysqlOperations;
import com.xiaokunliu.web.repository.users.po.SysUsers;
import com.xiaokunliu.web.repository.users.repository.SysUsersRepository;
import org.springframework.stereotype.Repository;

/**
 * date:2019/11/23 00:01
 * author:keithl
 * desc: business desc etc.
 */
@Repository
public class SysUsersRepo extends MysqlOperations<SysUsers> implements SysUsersRepository {


}
