<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: keithl
  Date: 2017/9/29
  Time: 上午11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>spittles Title</title>
</head>
<body>
    <table>
        <tr>
            <td>Id</td>
            <td>Date</td>
            <td>Message</td>
            <td>latitude</td>
            <td>longitude</td>
        </tr>

        <c:forEach items="${spittlesList}" var="spittle">
            <tr>
                <td><c:out value="${spittle.id}"</td>
                <td><c:out value="${spittle.time}"</td>
                <td><c:out value="${spittle.message}"</td>
                <td><c:out value="${spittle.latitude}"</td>
                <td><c:out value="${spittle.longitude}"</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
