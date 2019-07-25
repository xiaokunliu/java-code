##### Mybatis框架小结

> mybatis执行流程

```text
1. 读取mybatis-config.xml配置文件
2. 通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂对象
3. 通过SqlSesionFactory创建SqlSession会话对象
4. 通过sqlSession操作对象的CRUD并提交事务
5. 关闭sqlSession的连接
```

> mybatis初始化

```text
1。 通过SqlSessionFactoryBuilder读取mybatis-config.xml数据流并调用build()方法
2。 SqlSessionFactoryBuilder会根据输入流等信息创建XMLConfigBuilder对象
3。 SqlSessionFactoryBuilder会调用XMLConfigBuilder对象执行parse方法
4。 XMLConfigBuilder对象解析XML配置文件返回Configuration对象
5。 SqlSessionFactoryBuilder根据Configuration对象创建一个DefaultSessionFactory对象
6。 SqlSessionFactoryBuilder返回DefaultSessionFactory对象给客户端，提供客户端使用
```

> mybatis 配置




