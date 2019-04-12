package com.dtrees.study.springmvc_mybatis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * project:java-code
 * file:RootConfig
 * package:com.dtrees.study.springmvc_mybatis.config
 * date:2019/4/5 4:07 PM
 * author:keithl
 */
@Configuration
@Import({DataSourceConfig.class, SpringmvcConfig.class})
public class RootConfig {

}
