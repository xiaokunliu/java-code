package com.xiaokunliu.springdata.mongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Profile("mongodb")
@EnableMongoRepositories(basePackages = "com.xiaokunliu.springdata.mongodb.dao")
public class MongoConfig {

}
