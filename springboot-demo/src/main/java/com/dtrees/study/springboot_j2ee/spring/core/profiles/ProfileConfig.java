package com.dtrees.study.springboot_j2ee.spring.core.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by keithl on 2017/11/8.
 */
@Configuration
@ComponentScan("com.dtrees.study.springboot_j2ee.spring.core.profiles")
public class ProfileConfig {

    public final static String DEV_ENV = "DEV";
    public final static String PRODUCTION_ENV = "PRODUCTION";

    @Bean
    @Profile(DEV_ENV)     // profile设置为开发环境时实例化bean
    public ProfileBean getDevBean(){
        return new ProfileBean("from dev profile bean ");
    }

    @Bean
    @Profile(PRODUCTION_ENV)      // profile设置为生产环境时实例化bean
    public ProfileBean getProductionBean(){
        return new ProfileBean("from production profile bean ");
    }

}
