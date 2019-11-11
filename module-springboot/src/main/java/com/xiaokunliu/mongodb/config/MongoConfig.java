package com.xiaokunliu.mongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.xiaokunliu.mongodb.dao")
public class MongoConfig {

}
