package com.dtrees.study.spring.topic.condition;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by keithl on 2017/11/8.
 */

public class ConditionApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService = context.getBean(ListService.class);
        System.out.println(String.format("the current env[%s] show cmdName[%s]",context.getEnvironment().getProperty("env"),listService.showCmdName()));
    }
}
