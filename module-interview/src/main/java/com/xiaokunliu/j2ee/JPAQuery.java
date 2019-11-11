package com.xiaokunliu.j2ee;

import com.xiaokunliu.j2ee.jpa.Address;
import com.xiaokunliu.j2ee.jpa.JPAManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * project:java-code
 * file:JPAQuery
 * package:com.xiaokunliu.j2ee
 * date:2019/7/30 9:45 PM
 * author:keithl
 */
public class JPAQuery {

    private final static Logger LOGGER = LoggerFactory.getLogger(JPAQuery.class);
    private final EntityManager entityManager = JPAManagerFactory.getManager();

    public void jpaQuery() {
        // Users 是Java类实体
        String jpl = "select users.userName, users.userSex from  Users users where users.id  > ?1 and users.userName not like :name";
        Query query = entityManager.createQuery(jpl);
        query.setParameter(1, 10);
        query.setParameter("name", "M");

        List result = query.getResultList();
        LOGGER.info("the result is " + result);
    }

    public void jpaGrammer() {
        // with from
//        List result = entityManager.createQuery("from Users as users where users.id  > ?1 and users.userName not like :name")
//                .setParameter(1, 20)
//                .setParameter("name", "%F%")
//                .getResultList();
//        LOGGER.info("the result is "+result);

        // with select
        // id, users实体对象
        List resultUsers = entityManager.createQuery("select users.id, users from Users users where users.id  < ?1 ")
                .setParameter(1, 30)
                .getResultList();
        LOGGER.info("the result users is " + resultUsers);

        // select part attribute
        // same with jpaQuery
        jpaQuery();

        // 查询使用构造器
//        List constructorQuery = entityManager.createQuery("select new com.xiaokunliu.j2ee.jpa.Users(users.userName, users.userSex) from Users users where id > ?1")
//                .setParameter(1, 20)
//                .getResultList();
//        LOGGER.info("constructorQuery is "+constructorQuery);
//
//        // 使用distinct 排除相同的记录
//        List constructorQuery2 = entityManager.createQuery("select distinct new com.xiaokunliu.j2ee.jpa.Users(users.userName, users.userSex) from Users users where id > ?1")
//                .setParameter(1, 20)
//                .getResultList();
//        LOGGER.info("constructorQuery2 is "+constructorQuery2);

        // 多态查询
        List names = entityManager.createQuery("select users.userName from Users users where users.id > ?1 order by users.bitrhday")
                .setParameter(1, 90)
                .getResultList();
        LOGGER.info("names is " + names);

        // 关联和连接
        List joinResult = entityManager.createQuery("select users.userName, users.addresses from Users users where users.userSex = ?1")
                .setParameter(1, 1)
                .getResultList();
        LOGGER.info("joinResult is " + joinResult);

        // 结果分页
        int start = 0;
        int pageSize = 100;
        List pageResult = entityManager.createQuery("select users.userName, users.userSex from Users users where users.id > ?1")
                .setParameter(1, 1000)
                .setFirstResult(start)
                .setMaxResults(pageSize)
                .getResultList();
        LOGGER.info("pageResult is " + pageResult);
    }

    public void jpaWithNamedQuery() {
        // 命名查询
        List result = entityManager.createNamedQuery("user_query").getResultList();
        LOGGER.info("the named query result is " + result);

        // 批量更新
        entityManager.createQuery("update Users users set users.userName=?1, users.userSex=?2 where users.id > ?3")
                .setParameter(1, "xxxx")
                .setParameter(2, 1)
                .setParameter(3, 100)
                .executeUpdate();

        // 批量删除
        entityManager.createQuery("delete from Users users where users.id > ?1")
                .setParameter(1, 100)
                .executeUpdate();
    }

    public void jpaNativeQuery() {
        // 使用原生sql
        List result = entityManager.createNativeQuery("select users.id, users.user_name, users.user_sex from ss_users users where users.id > ?")
                .setParameter(1, 200)
                .getResultList();
        LOGGER.info("the query result is " + result);

        // 结果映射
        List result2 = entityManager.createNativeQuery("select a.id, a.detail from ss_address a where a.id > ?", "address_mapping")
                .setParameter(1, 20)
                .getResultList();
        LOGGER.info("the query result2 is " + result2);

        List result3 = entityManager.createNativeQuery("select a.id, a.detail from ss_address a where a.id > ?", Address.class)
                .setParameter(1, 20)
                .getResultList();
        LOGGER.info("the query result3 is " + result3);

        // 使用命名映射
        List result4 = entityManager.createNamedQuery("address_query")
                .setParameter(1, 10)
                .getResultList();
        LOGGER.info("the query result4 is " + result4);

        // 调用存储过程
        List result5 = entityManager.createNativeQuery("{call select_all_address(?)}")
                .setParameter(1, "%JAVA%")
                .getResultList();
        LOGGER.info("the query result5 is " + result5);

        List result6 = entityManager.createNativeQuery("{call select_all_address(?)}", Address.class)
                .setParameter(1, "%JAVA%")
                .getResultList();
        LOGGER.info("the query result6 is " + result6);
    }
}
