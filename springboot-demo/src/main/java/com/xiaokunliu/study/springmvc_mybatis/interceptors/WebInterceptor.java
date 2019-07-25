package com.xiaokunliu.study.springmvc_mybatis.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * project:java-code
 * file:WebInterceptor
 * package:com.xiaokunliu.springmvc_mybatis.interceptors
 * date:2019/4/4 11:32 PM
 * author:keithl
 */
public class WebInterceptor implements HandlerInterceptor {

    /**
     * 该方法是进行拦截器处理拦截的，将在Controller处理之前调用，该方法的返回值为true拦截器才会继续往下执行，返回false的时候整个请求就结束了
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        // 校验处理拦截器的业务需求
        return false;
    }

    /**
     * 该方法将在Controller方法调用之后执行，方法可以对ModelAndView进行操作
     * 该方法也只能在当前的Interceptor的preHandle方法的返回值为true时才执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    /**
     * 该方法在整个请求完成之后执行，主要作用是用于清理资源
     * 同时也只能在当前的Interceptor执行preHandle方法返回为true时才会执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }
}
