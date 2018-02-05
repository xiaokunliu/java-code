package com.dtrees.study.spring.core.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by keithl on 2017/11/8.
 */
@Configuration
@ComponentScan("com.dtrees.study.spring.core.el")
@PropertySource("classpath:study/core/el/el.properties")     // 7
public class ELConfig {

    /**
     * 注入配置文件:
     *  注入配置文件需要使用@PropertySource来指定文件地址,若使用@Value注入还需要配置一个PropertySourcesPlaceholderConfigurer的Bean,
     *  注意此时是使用@Value("${mysql.user}")使用是$,不是#
     *  注入properties还可以使用Environment中获取
     * @return
     */
    @Bean   // 7
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("${mysql.user}") // 7
    private String mysqlUser;

    @Value("${mysql.password}") // 7
    private String mysqlPassword;

    @Autowired
    private Environment environment;

    @Value("注入普通字符串")
    private String normal;

    @Value("#{systemProperties['os.name']}")     // 注入操作系统属性
    private String osName;

    @Value("#{ T(java.lang.Math).random() * 100.00 }")      // 注入表达式结果
    private double number;

    @Value("#{ELProperties.others}")        //注入其他bean的属性
    private String fromAnother;

    @Value("classpath:study/core/el/el.properties")  // 注入文件资源
    private Resource fileResource;

    @Value("http://www.baidu.com")      // 注入网址资源
    private Resource webUrl;


    public void output(){
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(number);
            System.out.println(fromAnother);
            System.out.println(IOUtils.toString(fileResource.getInputStream(),"UTF-8"));
            System.out.println(IOUtils.toString(webUrl.getInputStream(),"UTF-8"));
            System.out.println(mysqlUser);
            System.out.println(mysqlPassword);
            System.out.println(environment.getProperty("mysql.user"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
