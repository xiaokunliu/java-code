<%@page language="java" contentType="text/html; charset-UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
</head>
<body>
<div id="push-message"></div>
<%--引入jquery script TODO--%>
<script type="text/javascript">

    <%--sse客户端的配置编码--%>
    if (!!Window.EventSource){
        var source = new EventSource("push");
        var str = '';
        source.addEventListener("message",function (e) {
           str += e.data +"<br/>";
            $("#push-message").html(str);
        });

        source.addEventListener("open",function (e) {
            console.log("open the sse connection ...");
        },false);

        source.addEventListener("error",function (e) {
            if (e.readyState == EventSource.CLOSED){
                console.log("close the sse connection ..");
            }else{
               console.log(e.readyState);
            }
        },false);

    }else{
        console.log("您的浏览器不支持SSE客户端");
    }

</script>
</body>
</html>