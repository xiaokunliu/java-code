##### spring & mybatis 实战总结

###### springmvc
> springmvc执行流程

```text
1. 用户向服务器发送请求，请求被前端控制器DispatcherServlet拦截
2. DispatcherServlet对请求URL（统一资源定位符）进行解析，得到URI（请求资源标识符），然后根据该URI调用HandlerMapping获得Handler配置的所有相关对象，包括Handler对象以及Handler对应的拦截器，这些对象会被封装到一个HandlerExecutionChain对象返回
3. DispatcherServlet根据获得的Handler选择一个合适的HandlerAdapter，HandlerAdapter的设计符合面向对象单一设计原则，代码架构清晰，便于维护，可复用性强，HandlerAdapter会被用于处理多种Handler，调用多种Handler实际处理请求的方法
4. 提取请求中的模型数据，开始执行Handler（Controller），在填充Handler的入参过程中将根据配置，Spring会额外做如下事情
    1）消息转换，将请求消息转换为对象，将对象转换为指定的响应信息
    2）数据转换，对请求消息进行数据转换，如String转换层Integer/Double对象等
    3）数据格式化，对请求消息进行数据格式化，如将字符串转换成格式化数字或者格式化日期
    4）数据验证，验证数据的有效性（长度/格式等），验证结果存储到BindingResult或者Error中
5. Handler执行完成之后，向DispatcherServlet返回一个ModelAndView对象，ModelAndView对象中应该包含视图名称/视图名称和模型
6. 根据返回的ModelAndView对象，选择一个合适的ViewResolver（视图解析器）返回给DispatcherServlet
7. ViewResolver结合Model和View来渲染视图
8. 将视图渲染结果返回给客户端
```


> springmvc处理request注解

```text
1. body部分：@RequestParam   @RequestBody
2. uri部分：@PathVariable
3. header部分：@RequestHeader   @CookieValue
4. attribute部分: @SessionAttributes    @ModelAttribute

#####
@RequestMapping注解支持的常用属性
1）value属性。用来映射一个请求或者一个方法
2）method属性。处理http的请求方式
3）consumes属性，指定处理请求的提交类型（Content-Type）
4）produces属性，返回的内容类型必须是request请求头（Accept）中所包含的类型
5）params属性，指定request中必须包含某些参数时才进行处理
6）headers属性，指定request中必须包含指定的header值，才能让方法处理请求
```

###### mybatis









