package com.xiaokunliu.interview.web.infrastructure.web;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * date:2019/11/28 10:37
 * author:keithl
 * desc: business desc etc.
 */
public class WebInterceptors implements HandlerInterceptor {

    // 处理拦截器
    // Spring 拦截器 -- 针对 Spring 容器进行拦截
    // 过滤器 -- 仅仅针对Web下的Servlet进行过滤
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
