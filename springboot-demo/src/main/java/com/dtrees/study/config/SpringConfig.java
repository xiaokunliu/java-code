package com.dtrees.study.config;

/**
 * Created by keithl on 2017/11/8.
 */

public class SpringConfig {

    /**
     * 依赖注入
     *   声明Bean的注解:
         @Component :没有明确的角色
         @Service :在Service层中使用
         @Repository:在DAO中使用
         @Controller:在展现层中使用

         注入Bean的注解:
         @Autowired:Spring提供的注解
         @Inject:JSR-330提供的注解 :javax.inject jar包
         @Resource:JSR-225提供的注解
     */


    /**
     *  Java 配置
         @Configuration :声明当前类是一个配置类,相当与一个Spring配置的xml文件
         @Bean:注解在方法上,声明当前的方法返回值是一个Bean
         全局使用Java配置(如数据库相关配置、MVC相关配置),业务Bean的配置使用注解配置（即上述的注解配置）
     */


    // AOP:目的是解耦,可以让一组类共享相同的行为
//    @Aspect:声明是一个切面
//    Advice:定义advice,可以直接拦截规则（切点）作为参数
    //    @After()
    //    @Before()
    //    @Around()

//  PointCut:切点,为了使切点复用,可以使用@PointCut专门定义拦截规则,然后在上述的Advice的参数中调用

//    符合条件中个拦截点处称为连接点
//    Spring本身在事务处理(@Transactional)和数据缓存(@Cacheable)上都使用这种形式的拦截

}
