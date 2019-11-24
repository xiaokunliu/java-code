package com.xiaokunliu.web.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

//    //将web提交的请求字符串参数转换为日期类型
//    @Autowired
//    private RequestMappingHandlerAdapter handlerAdapter;
//
//    /**
//     * 增加字符串转日期的功能
//     */
//    @PostConstruct
//    public void initEditableAvlidation() {
//        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer)handlerAdapter.getWebBindingInitializer();
//        if (null != initializer.getConversionService()) {
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
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//
//            //重写父类提供的跨域请求处理的接口
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                //添加映射路径
//                registry.addMapping("/**")
//                        //放行哪些原始域
//                        .allowedOrigins("*")
//                        //是否发送Cookie信息
//                        .allowCredentials(true)
//                        //放行哪些原始域(请求方式)
//                        .allowedMethods("GET","POST", "PUT", "DELETE")
//                        //放行哪些原始域(头部信息)
//                        .allowedHeaders("*")
//                        //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
//                        .exposedHeaders("Header1", "Header2");
//            }
//        };
//    }
//
//    @Bean
//    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
//        return new RestTemplate(factory);
//    }
//
//    @Bean
//    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setConnectTimeout(6000);
//        factory.setReadTimeout(6000);
//        return factory;
//    }
}
