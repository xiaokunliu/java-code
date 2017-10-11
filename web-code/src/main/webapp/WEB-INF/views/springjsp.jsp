<%--
  Created by IntelliJ IDEA.
  User: keithl
  Date: 2017/9/29
  Time: 下午5:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>使用Spring库的JSP标签</title>
</head>
<body>

    <sf:form method="post" commandName="webform">
       First Name:<sf:input path="firstName"/><br>
        Last Name:<sf:input path="lastName"/><br>
        Email:<sf:input path="email"/>
        UserName:<sf:input path="username"/>
        Password:<sf:password path="password"/>
        <input type="submit" value="Register">
    </sf:form>
</body>
</html>
