package com.xiaokunliu.activemq.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * project:album
 * file:RedisProperties
 * package:com.xiaokunliu.album.prop
 * date:2018/5/6 上午12:06
 * author:keithl
 */
@Component
@ConfigurationProperties(prefix="mq.settings")
public class MQProperties {


}
