package com.xiaokunliu.study.springboot_j2ee.spring.config.aop;

import org.springframework.stereotype.Service;

/**
 * Created by keithl on 2017/11/8.
 */
@Service
public class AopService {

    public void add(){
        System.out.println("execute Aop Service add ...");
    }
}
