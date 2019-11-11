package com.xiaokunliu;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudApplication {

    public static void main( String[] args ) {
        /**
         * 删除图标显示
         */
        new SpringApplicationBuilder(CloudApplication.class).bannerMode(Banner.Mode.OFF).run(args);

        // 引入actuator，增加配置监控
        /**
         * 配置：
         *      应用配置
         *          自动化配置报告，/autoconfig
         *          获取上下文所有的bean，/beans
         *          获取配置属性信息报告，/configprops
         *          获取可用环境变量的报告，/env
         *          获取springmvc的所有映射，/mappings
         *          获取应用自定义信息，/info
         *      度量指标配置
         *          /metrics[/{name}]，获取监控度量指标，CPU/内存/线程/http等
         *          /health,  获取各类健康指标
         *          /dump， 暴露线程的信息
         *          /trace，跟踪基本http信息
         *      操作控制类
         *          默认开启使用控制类端点，关闭应用的端点，/shutdown,配置如下
         *          endpoints.shutdown.enabled=true
         *          只要访问/shutdown端点就能实现关闭该应用的远程操作
         */
    }
}
