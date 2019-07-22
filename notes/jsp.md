> 使用标签的意义
```text
1）取代JSP简陋的脚本语言开发，提高可阅读性；
2）分离JSP与html代码，降低维护成本；
3）美工人员能够更容易参与开发；
```

> 开发JSTL自定义标签步骤
```text
1）开发自定义标签处理类；
2）建立一个*.tld文件，每一个*.tld文件对应一个标签库，每个标签库科包含多个标签；
3）在JSP文件中使用自定义标签；
具体步骤：
a.自定义标签类应该继承一个父类：javax.servlet.jsp.tagext.SimpleTagSupport，且JSP自定义标签类需要有以下的要求：
1）若标签类包含属性，每个属性都应对应setter和getter方法
2）重写doTag方法，负责生成页面内容
b.建立tld文件：
1）将该文件复制到web应用的WEB-INF/的路径下
2）引入一个tld模板文件
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<taglib xmlns="http://java.sun.com/xml/ns/j2ee"
     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee web-jsptaglibrary_2_0.xsd"
     version="2.0">
       <!-- 定义该标签库的版本 -->
     <tlib-version>1.0</tlib-version>

       <!-- 定义该标签库的默认短名 -->
     <short-name>mytaglib</short-name>

     <!-- 定义该标签库的URI -->
     <uri>http://www.crazyit.org/mytaglib</uri>

     <!--  定义标签库 -->
     <tag>
          <!-- 定义标签名 -->
          <name>helloWorld</name>
          <!-- 定义标签处理类 -->
          <tag-class>lee.HelloWorldTag</tag-class>
          <!-- 定义标签体为空 -->
          <body-content>empty</body-content>
          <!--  定义属性 -->
   <attribute>
               <name>driver</name>
               <required>true</required>
               <fragment>true</fragment>
          </attribute>
     </tag>
</taglib>
```
```text
attribute对应的子元素值如下：
        1）name：设置属性名称，子元素的值是字符串值；
        2）required：设置该属性是否为必需属性，子元素的值为true或者是false；
        3）fragment：设置该属性是否支持JSP脚本、表达式等动态内容，子元素是true或是false
body-content子元素对应值如下：
1）tagdependent：指定标签处理类自己负责处理标签体；
2）empty：指定该标签只能作为空标签使用；
3）scriptless：指定该标签的标签提可以是静态html元素、表达式语言，但不允许出现JSP脚本；
4）JSP：指定该标签的标签体可以使用JSP脚本，JSP2.0之后的标签是不可以指定为JSP；
5）dynamic-attributes：指定该标签是否支持动态属性，只有当指定动态属性标签时才需要该子元素；

c.使用标签库
1）导入标签库
<%@ taglib uri="http://www.crazyit.org/mytaglib" prefix="tagPredix"%>
2）使用标签
<tagPredix:tagName tagAttribute="">
<tagBody/>
</tagPredix>
若没有标签体，则可以写成：
<tagPredix:tagName tagAttribute=""/>
```



