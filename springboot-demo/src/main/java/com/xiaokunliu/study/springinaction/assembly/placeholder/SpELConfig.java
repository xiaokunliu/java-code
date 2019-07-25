package com.xiaokunliu.study.springinaction.assembly.placeholder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.List;

/**
 * Created by keithl on 2017/11/15.
 */
@Configuration
@PropertySource("classpath:spring/app.properties")
@ComponentScan("com.xiaokunliu.ssm.core.assembly.placeholder")
public class SpELConfig {

    /**
     *  注意这里使用SpEl表达式的时候需要在配置文件配置PropertySourcesPlaceholderConfigurer
     * @return
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("#{3.1444}") //表示字面值
    private float v1;

    @Value("#{3.1444E}") //使用科学记数法
    private float v2;

    @Value("#{'使用字符串'}")    //字符串
    private String v3;

    @Value("#{false}")  // 使用boolean
    private boolean isBean;

    // 引用bean、属性和方法
    @Value("#{propertiesBean}")     // 注入bean
    private PropertiesBean propertiesBean;

    @Value("#{propertiesBean.title}")
    private String title;

    @Value("#{propertiesBean.getTitle()}")      // 使用方法
    private String title2;

    @Value("#{propertiesBean.getTitle().toUpperCase()}")      // 使用方法
    private String title3;

    // 安全类型检查,防止出现空指针
    @Value("#{propertiesBean?.getTitle()?.toUpperCase()}")      // 使用方法
    private String title4;

    // 类作用域的方法和常量,要用T()这个关键的运算符进行转换
    @Value("#{T(java.lang.Math).PI}")       //
    private double pi;

    // 执行运算符
    @Value("#{T(java.lang.Math).PI * 2.3}")     // 基本运算符
    private double result;

    @Value("#{T(java.lang.Math).PI > 5}")       // 比较运算符
    private boolean gt;

    @Value("#{propertiesBean.age == 20}")       // 比较运算符
    private boolean gt2;

    @Value("#{propertiesBean.age eq 20}")       // 比较运算符
    private boolean gt3;

    @Value("#{propertiesBean.title + ' to ' + propertiesBean.age}")     // 字符串连接
    private String str;

    // 三元运算符
    @Value("#{propertiesBean.age > 20?'old':'young'}")     // 字符串连接
    private String ageState;

    @Value("#{propertiesBean?.email?.matches(''[\\s._%+-]+@[\\s.-]+\\.com)}")   // 使用正则表达式
    private boolean emailChecked;

    // 从集合或者数组获取元素
    @Value("#{'string'[2]}")    // 下标基于0开始
    private String subString;

    // 查询运算,查找所有的歌中的名称包含有keithl的歌曲列表,
    @Value("#{propertiesBean.songs.?[name eq 'keithl']}")
    private List<Songs> songsList;

    // 查找集合中的第一个匹配的歌曲包含keithl的
    @Value("#{propertiesBean.songs.^[name eq 'keithl']}")
    private List<Songs> firstSong;

    // 查找集合中的第一个匹配的歌曲包含keithl的
    @Value("#{propertiesBean.songs.$[name eq 'keithl']}")
    private List<Songs> lastSong;

    // 投影运算,从集合的每个成员中选择特定的属性放到另外一个集合,下面将集合中song对象的name取出来并存放到新的集合中
    @Value("#{propertiesBean.songs.![name]}")
    private List<String> titleList;


    @Override
    public String toString() {
        return "SpELConfig{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", v3='" + v3 + '\'' +
                ", isBean=" + isBean +
                ", propertiesBean=" + propertiesBean +
                ", title='" + title + '\'' +
                ", title2='" + title2 + '\'' +
                ", title3='" + title3 + '\'' +
                ", title4='" + title4 + '\'' +
                ", pi=" + pi +
                ", result=" + result +
                ", gt=" + gt +
                ", gt2=" + gt2 +
                ", gt3=" + gt3 +
                ", str='" + str + '\'' +
                ", ageState='" + ageState + '\'' +
                ", emailChecked=" + emailChecked +
                ", subString='" + subString + '\'' +
                ", songsList=" + songsList +
                ", firstSong=" + firstSong +
                ", lastSong=" + lastSong +
                ", titleList=" + titleList +
                '}';
    }
}
