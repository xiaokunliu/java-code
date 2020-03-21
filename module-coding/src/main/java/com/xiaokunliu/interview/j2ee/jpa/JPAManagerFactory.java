package com.xiaokunliu.interview.j2ee.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * project:java-code
 * file:TestJPA
 * package:com.xiaokunliu.j2ee.jpa
 * date:2019/10/2 09:34
 * author:keithl
 */
public class JPAManagerFactory {

    private final static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("qs");
    private static EntityManager manager = null;

    static {
        manager = entityManagerFactory.createEntityManager();
    }

    /**
     * 省略了配置的步骤，也就是没有配置persistence.xml  -- 可以转换为注解的方式，使用springboot提供的支持，省去这些创建的步骤
     */

    private JPAManagerFactory() {
    }

    public static EntityManager getManager() {
        return manager;
    }
}
