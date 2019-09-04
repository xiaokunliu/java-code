##### springboot 日志配置（Spring Boot 默认的日志框架 logback）

> 添加日志依赖

```text
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-logging</artifactId>
</dependency>
```

> 控制台输出

```text
日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
Spring Boot中默认配置ERROR、WARN和INFO级别的日志输出到控制台。您还可以通过启动您的应用程序–debug标志来启用“调试”模式（开发的时候推荐开启）,以下两种方式皆可：

在运行命令后加入--debug标志，如：$ java -jar springTest.jar --debug
在application.properties中配置debug=true，该属性置为true的时候，核心Logger（包含嵌入式容器、hibernate、spring）会输出更多内容，但是你自己应用的日志并不会输出为DEBUG级别
```

> 文件输出

```text
logging.file，设置文件，可以是绝对路径，也可以是相对路径。如：logging.file=my.log
logging.path，设置目录，会在该目录下创建spring.log文件，并写入日志内容，如：logging.path=/var/log

如果只配置 logging.file，会在项目的当前路径下生成一个 xxx.log 日志文件。
如果只配置 logging.path，在 /var/log文件夹生成一个日志文件为 spring.log

注：二者不能同时使用，如若同时使用，则只有logging.file生效
默认情况下，日志文件的大小达到10MB时会切分一次，产生新的日志文件，默认级别为：ERROR、WARN、INFO
```

> 自定义日志配置

* Logback：logback-spring.xml, logback-spring.groovy, logback.xml, logback.groovy
* Log4j：log4j-spring.properties, log4j-spring.xml, log4j.properties, log4j.xml
* Log4j2：log4j2-spring.xml, log4j2.xml
* JDK (Java Util Logging)：logging.properties











