package com.xiaokunliu.interview.j2ee.jpa;

import javax.persistence.EntityManager;

/**
 * project:java-code
 * file:TestJPA
 * package:com.xiaokunliu.j2ee.jpa
 * date:2019/10/2 09:41
 * author:keithl
 */
public class TestJPA {

    private EntityManager entityManager = JPAManagerFactory.getManager();

    /**
     * 没有配置Users.orm.xml    --   可以转换为注解的方式
     */

    // 测试事务
    public void testTransaction() {
        try {
            entityManager.getTransaction().begin();

            // find from db by id = 1
            Users users = entityManager.find(Users.class, 1);
            // update the fields to db
            users.setAtavar("https://oss.aliyun.com/avatvar/990.png");// Transient 没有持久化到数据库中
            users.setUserName("xiaokun");

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }


    //管理实体
    public void testManagerEntity() {
        /**
         *  新建的状态：find/getReference/
         *  托管状态：persist
         *
         */
        Users user = new Users();
        // user setXXX
        // ...

        // 持久化实体
        entityManager.persist(user);

        // update user
        user.setUserName("xxxx");

        // merge
        // find
        Users users = entityManager.find(Users.class, 2);
        // transfer users to remote and the remote change user
//        Users newUser = getRemoteUers(users);
        // 将实体修改的信息进行合并
        /**
         *  // 新建/脱管会持久化到数据库
         *  托管： 会被忽略
         *  被删除：抛出异常
         */
//        entityManager.merge(newUser);

        // 删除实体
        /**
         * 新建：会被忽略
         * 托管：转换为被删除的状态
         * 脱管：抛出异常
         * 被删除：会被忽略
         */
//        entityManager.remove(user);

        /**
         *  刷新实体
         *      将底层数据库数据同步到当前实体数据中，保持数据一致性
         */
        entityManager.refresh(user);

    }
}
