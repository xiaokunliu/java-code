package com.xiaokunliu.study.springboot_j2ee.spring.core.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by keithl on 2017/11/8.
 */

public class ScopeApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
        SingletonService singletonService1 = applicationContext.getBean(SingletonService.class);
        SingletonService singletonService2 = applicationContext.getBean(SingletonService.class);

        System.out.println(singletonService1 == singletonService2);

        PrototypeService prototypeService1 = applicationContext.getBean(PrototypeService.class);
        PrototypeService prototypeService2 = applicationContext.getBean(PrototypeService.class);
        System.out.println(prototypeService1 == prototypeService2);
    }
}
