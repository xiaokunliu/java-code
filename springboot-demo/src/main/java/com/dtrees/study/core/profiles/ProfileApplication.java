package com.dtrees.study.core.profiles;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by keithl on 2017/11/8.
 */

public class ProfileApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //先设置profile所需要的环境
        context.getEnvironment().setActiveProfiles(ProfileConfig.PRODUCTION_ENV);
        // 然后注册bean配置类
        context.register(ProfileConfig.class);
        // 刷新容器
        context.refresh();

        ProfileBean profileBean = context.getBean(ProfileBean.class);
        System.out.println(profileBean.getContext());
    }
}
