package com.xiaokunliu.web.users.domain.user.repository;

import com.google.common.collect.Lists;
import com.xiaokunliu.web.infrastructure.config.DBConfig;
import com.xiaokunliu.web.repository.users.po.SysUsers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * date:2019/11/23 00:03
 * author:keithl
 * desc: junit4 test case for SysUsersRepoTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfig.class)
@SpringBootTest
public class SysUsersRepoTest {

    @Autowired
    private SysUsersRepo sysUsersRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return null;
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testClass() throws Exception {
        System.out.println(sysUsersRepo);
        System.out.println(jdbcTemplate);
        System.out.println(dataSource.getConnection());
        // TODO connection 为空？
//        System.out.println(dataSource.getConnection());
//        System.out.println(dataSourceProperties.getDriverClassName());
    }

    @Test
    public void testAdd() throws Exception {
        SysUsers sysUsers = new SysUsers();
        sysUsers.setAvatar("https://baidu.com/");
        sysUsers.setCreatedBy("keithl");
        sysUsers.setCreatedTime(new Date());
        sysUsers.setDelFlag("N");
        sysUsers.setDeptId(90L);
        sysUsers.setEmail("kxl602@163.com");
        sysUsers.setLoginDate(new Date());
        sysUsers.setLoginIP("127.0.0.1");
        sysUsers.setLoginName("admin");
        sysUsers.setPassword("xxxxxxx");
        sysUsers.setPhonenumber("15915840810");
        sysUsers.setUserType("HS");
        sysUsers.setRemark("keithl leaves message");
        sysUsers.setUserName("user name");
        sysUsers.setUserName("admin");
        sysUsers.setUpdatedBy("admin");
        sysUsers.setStatus("F");
        sysUsers.setSalt("salt");
//        sysUsers.setUserId();
        sysUsersRepo.addEntity(sysUsers);
    }

    @Test
    public void testBatchAdd() throws Exception {
        List<SysUsers> entityList = Lists.newArrayList();
        for (int index = 0; index <= 100; index++) {
            SysUsers sysUsers = new SysUsers();
            sysUsers.setAvatar("https://baidu.com/");
            sysUsers.setCreatedBy("keithl");
            sysUsers.setCreatedTime(new Date());
            sysUsers.setUpdateTime(new Date());
            sysUsers.setDelFlag("N");
            sysUsers.setDeptId(90L);
            sysUsers.setEmail("kxl602@163.com");
            sysUsers.setLoginDate(new Date());
            sysUsers.setLoginIP("127.0.0.1");
            sysUsers.setLoginName("admin");
            sysUsers.setPassword("xxxxxxx");
            sysUsers.setPhonenumber("15915840810");
            sysUsers.setUserType("H");
            sysUsers.setRemark("keithl leaves message");
            sysUsers.setUserName("user name");
            sysUsers.setUserName("admin");
            sysUsers.setUpdatedBy("admin");
            sysUsers.setStatus("F");
            sysUsers.setSalt("salt");

            entityList.add(sysUsers);
        }
        sysUsersRepo.batchAddEntity(entityList);
    }

    @Test
    public void testUpdate() throws Exception {
        SysUsers sysUsers = sysUsersRepo.queryById(14);
        sysUsers.setRemark("change remark for keithl");
        sysUsersRepo.updateById(sysUsers.getUserId(), sysUsers);
    }

    @Test
    public void testDelete() {
        sysUsersRepo.deleteById(201);
    }

    @Test
    public void testBatchDelete() {
        List<Serializable> ids = Lists.newArrayList();
        ids.add(202);
        ids.add(203);
        ids.add(204);
        ids.add(205);
        sysUsersRepo.batchDelete(ids);
    }

    @Test
    public void testQuery() {
        SysUsers sysUsers = sysUsersRepo.queryById(1);
        System.out.println(sysUsers);
    }

    @Test
    public void testQueryLimited() {
        List<SysUsers> users = sysUsersRepo.queryLimited(30, 20);
        System.out.println(users);
    }

    @Test
    public void testQueryByDeptId() {
        long deptId = 90L;
        List<SysUsers> users = sysUsersRepo.queryAllByDeptId(deptId);
        System.out.println(users);
    }
}