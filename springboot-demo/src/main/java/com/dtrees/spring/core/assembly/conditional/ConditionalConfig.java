package com.dtrees.spring.core.assembly.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by keithl on 2017/11/14.
 */
@Configuration
public class ConditionalConfig {

    @Bean
    @Conditional(StringConditional.class)
    public String getString(){
        return new String("conditional is true");
    }
}
