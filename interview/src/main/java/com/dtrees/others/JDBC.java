package com.dtrees.others;

import javax.sql.DataSource;
import java.sql.*;

/**
 * project:keithl
 * file:JDBC
 * package:com.dtrees.others
 * date:2018/9/28 上午7:37
 * author:keithl
 */
public class JDBC {

    /**
     * 传递JDBC每次进行数据库访问时都需要进行数据库连接，实际项目会考虑用数据源的方式管理数据库连接
     *      1。基于Spring容器管理数据源
     *      2。基于应用服务器管理数据源，WebLogic或JBoos，同时能够支持JTA事务
     */

//    DriverManager
//    Connection
//    Statement
//    PreparedStatement
//    ResultSet
//    ResultSetMetaData

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
     * DataSource：应用程序管理数据源和容器管理数据源
     */

}

