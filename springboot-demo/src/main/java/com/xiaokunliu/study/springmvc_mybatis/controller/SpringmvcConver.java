package com.xiaokunliu.study.springmvc_mybatis.controller;

import org.springframework.stereotype.Controller;

/**
 * project:java-code
 * file:SpringmvcConver
 * package:com.xiaokunliu.springmvc_mybatis.controller
 * date:2019/4/4 5:05 PM
 * author:keithl
 */
@Controller
public class SpringmvcConver {

    // 数据绑定的核心是DataBinder
    /**
     * springmvc框架将ServletRequest对象以及处理方法的参数对象实例传递给DataBinder，DataBinder调用装配在Spring Web上下文中的
     * ConversionService组件进行数据类型转换，数据格式化工作，并将ServletRequest中的消息填充到参数对象中，然后再调用Validator组件
     * 将已经绑定请求消息数据的参数对象进行数据合法性校验，并生成最终数据绑定结果BindingResult对象，BindingResult包含已经完成数据绑定的
     * 参数对象，还包含响应的校验错误对象，SpringMVC抽取BindingResult中的参数对象以及校验错误对象，将她们赋给处理方法的相应参数
     */

    /**
     * SpringMVC 三种转换器
     *  Converter<S,T> : 将S类型对象转换为T类型对象
     *  ConverterFactory<S,T> : 希望能够将一种类型对象转换为另一种类型及其子类对象，没有考虑上下文信息
     *  GenericConverter: 会根据源类对象以及目标对象的上下文信息进行类型转换
     */

    /**
     * 多种转换器执行的优先顺序
     * 1。查询通过@InitBinder装配的自定义编辑器
     * 2。查询通过ConversionService装配的自定义转换器
     * 3。查询通过WebBindingInitializer接口装配的全局自定义编辑器
     */


    // 格式转换器
//    Printer
//    Parser
//    Formatter
//    FormatterRegistrar
//    AnnotationFormatterFactory

    // ssm 内部实现的格式转换器
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE，pattern = "yyyy-MM-dd HH:mm:ss", style = "SS")
//    @NumberFormat(pattern = "",style = NumberFormat.Style.CURRENCY)


    // 数据校验
//    Validator
//    Errors,存放错误信息的接口
//    ValidationUtils，提供一个关于校验的工具类
//    LocalValidatorFactoryBean实现Validator接口也实现JSR303的Validator接口
    /**
     * JSR303 校验：为Bean数据合法性校验所提供的一个标准规范，叫做BeanValidator
     * HibernateValidator实现JSR303
     */


}
