package com.xiaokunliu.study.springboot_j2ee.spring.web;

import com.xiaokunliu.study.springboot_j2ee.spring.web.conveter.WebMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * Created by keithl on 2017/11/29.
 */
@Configuration
@EnableScheduling
@EnableWebMvc       // 开启Spring MVC的支持
@ComponentScan("com.xiaokunliu.study.springboot_j2ee.spring.web")
public class WebConfig extends WebMvcConfigurerAdapter{

    //WebMvcConfigurerAdapter:重写其父类方法可对Spring MVC进行配置

    // 设置视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // 运行的时候代码会将我们的页面自动编译到/WEB-INF/classes/views/下,
        // 在spring boot将会使用Thymeleaf作为模板的时候就不需要这样配置
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    // 设置文件的存放的目录,对外暴露访问路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置静态资源
        registry.addResourceHandler("/views/asserts/**").addResourceLocations("classpath:/views/asserts/");
    }

    // 配置拦截器
    @Bean
    public WebInterceptor webInterceptor(){
        return new WebInterceptor();
    }

    // 重写方法,注册自定义的拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webInterceptor());
    }

//    @ControllerAdvice:可以将控制器的全局配置放置在同一个位置,注解了@Controller的类的方法可以使用以下的注解
//    @ExceptionHandler:用于全局处理控制器的异常
//    @InitBinder:用来设置WebDataBinder（用来绑定前台请求参数到Model中）
//    @ModelAttribute:绑定键值对到Model里,此处是让全局的@RequestMapping都能获得在此处设置的键值对

    // 路径匹配参数配置
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false); // 不可忽略路径参数后面的"."
    }

    //================================文件上传============================================
    // 添加转向upload的页面的ViewController
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        // 访问:http://domain/toUpload
        registry.addViewController("/toUpload").setViewName("/upload");
        // 配置converter
        registry.addViewController("/converter").setViewName("/converter");
        // 配置sse
        registry.addViewController("/sse").setViewName("/sse");
        // 配置异步
        registry.addViewController("/async").setViewName("/async");
    }

    // 添加多文件上传的配置
    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }

    // 配置HttpMessageConverter
    @Bean
    public WebMessageConverter converter(){
        return new WebMessageConverter();
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }

    // sse:服务器端推送技术,
    /**
     * 当客户端服务器发送请求,服务端会抓住这个请求不放,等有数据更新的时候才返回给客户端,当客户端接收到消息后,再向
     * 服务端发送请求,周而复始,减少服务器的请求数量,大大减少了服务器的压力
     * WebSocket也可以实现上述的功能
     */
}
