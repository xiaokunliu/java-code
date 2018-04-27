#### spring-boot 配置
> spring-boot 配置文件properties加载顺序

```code 
1. 在命令行输入参数
2. SPRING_APPLICATION_JSON 中的属性,SPRING_APPLICATION_JSON是以JSON格式配置在系统环境变量中的内容
3. java:comp/env中的JNDI属性
4. java系统的属性,可以通过System.getProperties()获得的内容
5. 操作系统的环境变量
6. 通过random.* 配置的随机属性
7. 位于当前应用jar包之外,针对不通的{profile}环境配置文件内容,如application-{profile}.properties或者是YAML定义的配置文件
8. 位于当前应用jar包之内,针对不通的{profile}环境配置文件内容,如application-{profile}.properties或者是YAML定义的配置文件
9. 位于当前应用jar包之外,如application.properties或者是YAML定义的配置文件
10.位于当前应用jar包之内,如application.properties或者是YAML定义的配置文件
11.在@Configuration注解修改的类中,通过@PropertySource注解定义的属性
12.应用默认属性,使用SpringApplication.setDefaultProperties定义的内容
```

