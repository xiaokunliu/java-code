package com.dtrees.study.topic;

/**
 * Created by keithl on 2017/11/8.
 */

public class SpringTopic {

    // Spring 高级话题
    /**
     *  Spring Aware,作用是为了能够使用Spring框架容器本身提供的资源,声明的bean这时候就需要和Spring框架容器进行耦合,
     *  才能够调用spring 容器所提供的资源
     *  Spring Aware的目的是为了让Bean获得Spring容器的服务,因为ApplicationContext接口集成了MessageSource接口,
     *  ApplicationEventPublisher接口和ResourceLoader接口，所以Bean继承ApplicationContextAware可以获得容器的所有服务
     *  不过原则上是用到什么接口就实现什么接口
     */

    /**
     * 多线程
     * Spring通过任务执行器(TaskExecutor)来实现多线程和并发编程,使用ThreadPoolTaskExecutor可实现一个基于线程池的TaskExecutor,
     * 而实际开发是非阻塞,即异步的,因此需要在配置类中通过@EnableAsync开启对异步任务的支持,并通过实际执行的Bean方法中使用@Async注解来声明其是一个异步任务
     */

    /**
     * 计划任务
     * 首先通过在配置类注解@EnableScheduling来开启对计划任务的支持,然后在执行计划任务的方法上注解@Scheduled声明这个一个计划任务
     */

    /**
     * 条件注解@Conditional
     *  能够根据某一个特定的条件来创建一个特定的bean,比如某一个jar在一个类路径下会自动加载一个或者多个bean
     *  简而言之,就是根据特定条件来控制bean的创建行为
     */

    /**
     * 组合注解与元注解
     *  Spring的注解主要是用来配置和注入Bean,以及AOP相关的配置@Transactional
     *  元注解:可以注解到别的注解上的注解,被注解的注解称为组合注解,组合注解具备元注解上的功能
     */

    /**
     * @Enable* 注解的工作原理
     *       @EnableAspectJAutoProxy:开启对AspectJ自动代理的支持
             @EnableAsync:开启异步方法的支持
             @EnableScheduling:开启计划任务的支持
             @EnableWebMvc:开启对Web MVC的支持
             @EnableConfigurationProperties:开启对@ConfigurationProperties注解配置Bean的支持
             @EnableJpaRepositories:开启对Spring Data JPA Repository的支持
             @EnableTransactionManagement:开启注解式的事物支持
             @EnableCaching:开启注解式缓存的支持

     */

    /**
     *  Spring Test测试
     *    Spring 通过Spring TestContext Framework对集成测试提供顶级支持,不依赖于特定的测试框架,即可以用Junit,可以用TestNG
     *    Spring使用SpringJUnitClassRunner类，通过@ContextConfiguration来配置ApplicationContext,
     *    通过@ActiveProfile确定动态的profile
     *    在测试test中有示例
     */

}
