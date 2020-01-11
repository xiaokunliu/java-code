package com.xiaokunliu.web.infrastructure.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * date:2019/11/28 10:34
 * author:keithl
 * desc: business desc etc.
 */
@RestControllerAdvice(basePackages = "com.xiaokunliu.web.*.api")
public class WebErrorAdvice {

    // 专门拦截Controller异常信息
    @ExceptionHandler(WebException.class)
    public Object handlerWebException(HttpServletRequest request, Throwable throwable) {
        return "";
    }
}
