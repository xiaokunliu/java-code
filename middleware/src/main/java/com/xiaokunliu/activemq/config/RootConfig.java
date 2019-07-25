package com.xiaokunliu.activemq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * project:album
 * file:RootConfig
 * package:com.xiaokunliu.album.config
 * date:2018/4/22 下午6:37
 * author:keithl
 */
@Configuration
@Import({WebConfig.class})
public class RootConfig {

    // 需要对发布订阅模式设置工厂实例
    @Bean
    public JmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(Boolean.TRUE);
        return factory;
    }
}
