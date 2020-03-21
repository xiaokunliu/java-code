package com.xiaokunliu.interview.web.infrastructure.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * date:2019/11/22 21:01
 * author:keithl
 * desc: business desc etc.
 */
@Configuration
@ComponentScan(basePackages = "com.xiaokunliu.interview.web.*")
@EnableAutoConfiguration
public class DBConfig {

    // https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter

    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource druidDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(druidDataSource());
    }
}
