<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2018/8/12
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>示例</title>
</head>
<body>
<input type="button" onclick="asyncRequest()" value="请求天气"/>
<div id="taglist"></div>
</body>
<script type="text/javascript">
    function asyncRequest(){
        var httpRequest = new XMLHttpRequest();
        httpRequest.open("GET","http://localhost:8080/dep/test/TestHttpURLConnrction",true);
        httpRequest.onreadystatechange=function(){
            if(httpRequest.readyState ==4 && httpRequest.status ==200){
                var responseText= httpRequest.responseText;
                document.getElementById('taglist').innerHTML = httpRequest.responseText;

            }
        }
        httpRequest.send();
    }
</script>
</html>
