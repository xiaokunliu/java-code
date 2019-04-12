package com.dtrees.study.springboot_j2ee.spring.topic.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by keithl on 2017/11/8.
 */
@Configuration
@PropertySource("classpath:study/topic/env.properties")
public class ConditionConfig {

    @Bean
    @Conditional(WindowCondition.class)
    public ListService windowListService(){
        return new WindowListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxService(){
        return new LinuxListService();
    }

}
