package com.xiaokunliu.springmvc;

import com.xiaokunliu.springmvc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by keithl on 2017/9/28.
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    /**
     * 配置web映射路径
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    /**
     * 指定Web的配置类
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * Spring Web 有两个上下文
     *  1)DispatcherServlet:加载包含Web组件的bean，如控制器、视图解析器以及处理器映 射
     *  2)ContextLoaderListener:加载应用中的其他bean。这些bean通常是驱动应用后端的 中间层和数据层组件
     *  AbstractAnnotationConfigDispatcherServletInitializer会同时创建DispatcherServlet和ContextLoaderListener
     */

    // Ctrl + H 查看继承结构
    // Show Diagrams 通过查看类之间关系的类图

}
