package com.xiaokunliu.study.springinaction.assembly.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Created by keithl on 2017/10/20.
 */
@Configuration
public class DataSourceConfig{

    // 将Dev 和 Product的配置整合成一个Bean中进行配置

    @Bean(destroyMethod = "shutdown")
    @Profile("dev")
    public DataSource devDataSource() {
        // 开发环境
        System.out.println("创建开发环境的数据源");
        return null;
    }

    @Bean(destroyMethod = "shutdown")
    @Profile("production")
    public DataSource proDataSource() {
        // 生产环境
        System.out.println("创建开发环境的数据源");
        return null;
    }

    /**
     * 尽管每个DataSource bean都被声明在一个profile中，
     * 并且只有当规定 的profile激活时，相应的bean才会被创建，但是可能会有其他的bean并没有声明在一个给定的profile范围内。没
     * 有指定profile的bean始终都会被创建，与激活哪个profile没有关系
     */

}
