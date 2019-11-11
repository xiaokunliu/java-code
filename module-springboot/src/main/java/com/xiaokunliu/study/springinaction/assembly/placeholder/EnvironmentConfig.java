package com.xiaokunliu.study.springinaction.assembly.placeholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by keithl on 2017/11/15.
 */
@Configuration
@ComponentScan("com.xiaokunliu.study.springinaction.assembly.placeholder")
@PropertySource("classpath:spring/app.properties")
public class EnvironmentConfig {

    @Autowired
    private Environment environment;    //app.properties 的数据注入到spring的Environment中

    /**
     * 希望这个属性必须要定义,使用getRequiredProperty
     * @return
     */
    @Bean
    public PropertiesBean propertiesBean(){
        return new PropertiesBean(environment.getProperty("title"),
                                  environment.getProperty("age",Integer.class));
    }

    //占位符,使用PropertySourcesPlaceholderConfigurer，因为它能够基于Spring Environment及 其属性源来解析占位符
//    @Bean
//    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
//        return new PropertySourcesPlaceholderConfigurer();
//    }
}
