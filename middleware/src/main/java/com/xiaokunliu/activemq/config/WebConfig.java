package com.xiaokunliu.activemq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * project:album
 * file:WebConfig
 * package:com.xiaokunliu.album.config
 * date:2018/4/23 下午11:45
 * author:keithl
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


    //将web提交的请求字符串参数转换为日期类型
    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

//    /**
//     * 增加字符串转日期的功能
//     */
//    @PostConstruct
//    public void initEditableAvlidation() {
//        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer)handlerAdapter.getWebBindingInitializer();
//        if(initializer.getConversionService()!=null) {
//            GenericConversionService genericConversionService = (GenericConversionService)initializer.getConversionService();
//            genericConversionService.addConverter(new String2DateConverter());
//        }
//    }
//
//    // fast json 配置 -- 使用注入的方式进行配置
//    @Bean
//    public HttpMessageConverters fastjsonHttpMessageConverters(){
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        HttpMessageConverter<?> converter = fastConverter;
//        return new HttpMessageConverters(converter);
//    }
}
