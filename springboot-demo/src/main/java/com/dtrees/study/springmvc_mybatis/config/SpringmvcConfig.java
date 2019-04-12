package com.dtrees.study.springmvc_mybatis.config;

import com.dtrees.study.springmvc_mybatis.interceptors.WebInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * project:java-code
 * file:SpringmvcConfig
 * package:com.dtrees.springmvc_mybatis.config
 * date:2019/4/4 11:30 PM
 * author:keithl
 */
@Configuration
@ComponentScan(basePackages={"com.dtrees.study.springmvc_mybatis"})
@EnableWebMvc
public class SpringmvcConfig extends WebMvcConfigurerAdapter {

    // 配置spring mvc拦截器
//    /**
//     * 方式一
//     * 添加拦截器
//     * @param registry
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        this.interceptorPath(registry.addInterceptor(new WebInterceptor()));
//    }

    // 添加拦截器方式二
    @Bean
    public WebInterceptor webInterceptor(){
        return new WebInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        this.interceptorPath(registry.addInterceptor(this.webInterceptor()));
    }

    private void  interceptorPath(InterceptorRegistration registration){
        registration.addPathPatterns("/interceptor_uri/");
    }
}
