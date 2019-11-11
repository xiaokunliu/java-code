package com.xiaokunliu.j2ee;

/**
 * project:keithl
 * file:JDBC
 * package:com.xiaokunliu.j2ee
 * date:2018/9/28 上午7:37
 * author:keithl
 */
public class JDBC {

    // 什么是JDBC？

    /**
     * 传递JDBC每次进行数据库访问时都需要进行数据库连接，实际项目会考虑用数据源的方式管理数据库连接
     *      1。基于Spring容器管理数据源
     *      2。基于应用服务器管理数据源，WebLogic或JBoos，同时能够支持JTA事务
     */

    // 传统JDBC编程步骤
//    DriverManager：加载数据库驱动
//    Connection：获取连接
//    Statement/PreparedStatement：创建执行sql语句的Statement/PreparedStatement
//    ResultSet && ResultSetMetaData：获取数据库执行sql结果并将数据结果保存在resultset对象中，如果执行是的DML语句，则返回结果是一个int型整数
//    close：回收数据库资源，即上述的ResultSet，Statement，Connection

    /**
     * 数据库连接池技术：改善频繁打开，关闭数据库连接的情形，可以使用连接池技术
     *      基本思路：当应用呈现启动的时候，系统主动创建足够的数据库连接，并将这些连接组成一个连接池，每次应用程序请求数据库连接时，无须重新打开连接，而是
     *      从池中取出已有的连接进行使用，使用完之后，不再关闭数据库连接，而是直接将该连接归还至连接池中
     * 连接池是数据库连接Connection对象的工厂，常用参数如下：
     *      1。连接池初始化连接数
     *      2。连接池最大连接数
     *      3。连接池的最小连接数
     *      4。连接池每次增加的容量
     */

    /**
     * DataSource：应用程序管理数据源和容器管理数据源，包含连接池和连接池管理两个部分
     * 开源组件实现：DBCP，C3P0
     */

}

