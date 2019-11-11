package com.xiaokunliu.study.springboot_j2ee.spring.core;
/**
 * Created by keithl on 2017/11/8.
 */

public class SpringCore {


    // Spring 核心
    /**
     * Bean的作用域
     *       Singleton:一个Spring容器只有一个bean实例,Spring默认配置全容器共享一个实例
             Prototype:每次调用新建一个bean实例
             Request:web项目中,给每一个http request新建一个bean实例
             Session:web项目中,给每一个http session新建一个bean实例
            GlobalSession:这个只在portal应用中有用,给每一个global http session新建一个bean实例
            StepScope:批处理
     */
    //

    /**
     * Spring EL 表达式,支持在xml和注解使用表达式,类似与JSP的EL表达式
     *     主要在@Value的参数中使用表达式
     */

    /**
     * Bean的初始化和销毁
     *  Java的配置方式:使用@Bean的initMethod和destroyMethod
     *  注解方式:利用JSR-250的@PostConstruct和@PreDestroy
     */


    /**
     * Profile
     *     1)通过设置Environment的ActiveProfiles来设定当前context的配置环境,开发中使用@Profile注解类或者方法,达到在不同情况下选择实例化不同的bean
     *     2)通过设定JVM的spring.profile.active参数来设置配置环境
     *     3)web项目设置的servlet的context parameter中
     *  2.5 servlet, 根据profiles active来配置
     *      <servlet>
                 <servlet-name>dispacther</servlet-name>
                 <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
                 <init-param>
                     <param-name>ssm.profiles.active</param-name>
                     <param-value>production</param-value>
                 </init-param>
             </servlet>
        3.0
         public class WebInit implements WebApplicationInitializer{

            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
            servletContext.setInitParameter("ssm.profiles.default","dev");
            }
        }
     */

    /**
     * 事件,Application Event
     *  遵循以下流程:
     *      1)自定义事件,继承ApplicationEvent
     *      2)定义事件监听器,实现ApplicationListener
     *      3)使用容器发布事件
     */


}
