<%@ page import="org.zerock.domain.UserVO" %><%--
  Created by IntelliJ IDEA.
  User: im-yegwang
  Date: 2021/04/05
  Time: 8:16 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1><%=((UserVO)session.getAttribute("user")).getEmail()%>님 반갑습니다</h1>
    <a href="/user/logout"></a>
  </body>
</html>
