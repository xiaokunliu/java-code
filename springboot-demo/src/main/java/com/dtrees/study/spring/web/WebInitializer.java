package com.dtrees.study.spring.web;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * Created by keithl on 2017/11/29.
 */
// 配置servlet3.0的接口,從而實現代替web.xml的位置
public class WebInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        context.setServletContext(servletContext);  // 新建WebApplicationContext,註冊配置類

        // 注冊Spring MVC的DispatcherServlet
        Dynamic servletRegistration = servletContext.addServlet("dispatcher",new DispatcherServlet(context));
        servletRegistration.addMapping("/");
        servletRegistration.setLoadOnStartup(1);

        // 开启异步方法的支持
        servletRegistration.setAsyncSupported(true);
    }
}
