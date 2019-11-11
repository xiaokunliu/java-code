package com.xiaokunliu.study.springmvc_mybatis.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * project:java-code
 * file:MyBatis
 * package:com.xiaokunliu.study.springmvc_mybatis.dao
 * date:2019/4/7 9:25 AM
 * author:keithl
 */
public class MyBatis {

    // mybatis相关的基本操作， 和当前项目代码没有直接关系，仅供学习参考

    public static void main(String[] args) throws Exception{

        InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        // 使用会话工厂应当用单例模式进行注入配置
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession  = sqlSessionFactory.openSession();
        // statement 为maper配置文件的对应的insert/update/delete/select的id
        sqlSession.insert("statement");
//        sqlSession.delete()
//        sqlSession.update()
//        sqlSession.selectList()
//        sqlSession.selectMap()

//        sqlSession.selectCursor()
//        sqlSession.select();
        sqlSession.commit();
        sqlSession.close();


        // mybatis核心api： http://www.mybatis.org/mybatis-3/zh/java-api.html
        // Mybatis事务管理机制 & 缓存机制
        /**
         * ACID
         *  原子性，事务是应用中不可再分的最小逻辑分体
         *  一致性，事务执行的结果，必须从数据库一种状态一致性状态转到另一种一致性状态
         *  隔离性，各个事务之间的执行是相互独立，互不影响
         *  持续性（持久化）：一旦事务提交，对数据所做的任何改变都会记录到永久存储器中
         */

        /**
         * Mybatis事务管理
         *  JDBC事务管理机制，利用java.sql.Connection对象完成对事务的提交，回滚和关闭等操作
         *  MANAGED事务管理机制，利用容器，如Weblogic/Jboss来实现对事务的管理
         */

        // 查看源代码
        // 事务工厂的创建  TransactionFactory
        // 在xml配置文件指定JDBC则会在mybatis内部使用JdbcTransactionFactory创建工厂
        // 使用JdbcTransaction得到的connection对象来管理transaction的作用域

        // 容器管理事务 -- 查看源代码
        //ManagedTransactionFactory创建ManagedTransaction，管理整个事务Transaction的整个生命周期，也就是使用该事务的commit和rollback不会对事务有什么影响，
        //将事务管理的权力全部交由容器来实现


        // Mybatis缓存
        // 一级缓存：会话级别的缓存，存在于SqlSession
        // 二级缓存：mapper级别的缓存，二级缓存是多个SqlSession共享的

        /**
         *  一级缓存
         *      在操作数据库的时候，构建SqlSession对象，对象中有一个HashMap用于存储缓存数据，不同的SqlSession的缓存数据区域（HashMap）是互不影响的
         *      一级缓存的作用域是在SqlSession范围的，当在同一个SqlSession中执行两次相同的sql语句时，第一次执行完毕会将数据库查询的数据写到缓存中（内存），
         *      第二次查询的时候会从缓存中获取，不再去底层查询数据库以提高查询效率。
         *      需要注意的是，如果是操作DML并提交到数据库，MyBatis会清空SqlSession的缓存，保证缓存中存储的对象信息是最新的信息，避免出现脏读
         *      当一个SqlSession结束后该SqlSession中的一级缓存也就不存在了，MyBatis默认开启一级缓存，不需要进行任何配置
         *
         *      MyBatis的缓存机制是基于id进行缓存的，也就是MyBatis使用HashMap缓存数据时，是使用对象的id作为key，对象作为value进行保存的
         */


        /**
         *  二级缓存
         *      使用二级缓存时候，多个SqlSession使用同一个mapper的sql语句去操作数据库，得到的数据会存在二级缓存区域中，同样是使用HashMap进行存储
         *      相比一级缓存，mapper缓存的范围更大，多个SqlSession可以共用二级缓存，二级缓存是SqlSession的
         *      二级缓存是多个SqlSession共享的，其作用域就是mapper的同一个namespace，不同的SqlSession两次执行相同的namesapce下的sql语句，且向sql
         *      中传递的参数也相同，即最终执行相同的sql语句，则第一次执行完毕之后会将数据库中查询的数据写到缓存中，第二次查询将直接从缓存中获取
         *
         *      Mybatis默认没有开启二级缓存，需要进行配置
         *      mybatis-config.xml
         *          <setting name="cacheEnabled" value="true"/>
         *      mapper.xml
         *          <cache/>
         */
    }

}
