package com.dtrees.redis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600 * 7 * 24) // 缓存时间为1周
public class SessionConfig {
    // maxInactiveIntervalInSeconds: 设置Session失效时间，使用Redis Session之后，原Boot的server.session.timeout属性不再生效

//    在测试方法中使用
//    @RequestMapping("/uid")
//    String uid(HttpSession session) {
//        UUID uid = (UUID) session.getAttribute("uid");
//        if (uid == null) {
//            uid = UUID.randomUUID();
//        }
//        session.setAttribute("uid", uid);
//        return session.getId();
//    }
}
