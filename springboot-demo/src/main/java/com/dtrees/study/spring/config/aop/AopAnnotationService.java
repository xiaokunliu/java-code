package com.dtrees.study.spring.config.aop;

import org.springframework.stereotype.Service;

/**
 * Created by keithl on 2017/11/8.
 */
@Service
public class AopAnnotationService {

    @Action(name="注解式的拦截service的add操作")
    public void add(){
        System.out.println("execute AopAnnotationService add method ...");
    }
}
