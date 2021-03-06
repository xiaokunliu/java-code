package com.xiaokunliu.study.springboot_j2ee.spring.topic.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by keithl on 2017/11/8.
 */

public class WindowCondition implements Condition{

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().getProperty("env").equalsIgnoreCase("windows");
    }
}
