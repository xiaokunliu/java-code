package com.xiaokunliu.study.springboot_j2ee.spring.topic.annotation;

import org.springframework.stereotype.Service;

/**
 * Created by keithl on 2017/11/8.
 */
@Service
public class AnnotationService {

    public void outputResult(){
        System.out.println("从组合注解中获取bean");
    }
}
