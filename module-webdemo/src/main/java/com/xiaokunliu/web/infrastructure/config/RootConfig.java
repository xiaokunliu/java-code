package com.xiaokunliu.web.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * project:album
 * file:RootConfig
 * package:com.dtrees.album.config
 * date:2018/4/22 下午6:37
 * author:keithl
 */
@Configuration
@Import({DBConfig.class, WebConfig.class})
public class RootConfig {

}
