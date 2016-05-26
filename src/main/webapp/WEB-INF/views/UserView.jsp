<%@ page import="com.vladshkerin.models.User" %>
<%@ page import="com.vladshkerin.services.UserService" %>
<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 22.03.16
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/UserView.css">
    <%
        for (Cookie cookie : request.getCookies()) {
            if ("color".equals(cookie.getName())) {
                %>
            <style>
                body {
                    background-color: <%=cookie.getValue()%>;
                }
            </style>
            <%
            }
        }
    %>
</head>
<body>
    Welcome back, <%=session.getAttribute("login")%>, <%=request.getAttribute("role")%>
    <a href="<%=request.getContextPath()%>/logout">logout</a>
<table>
    <caption>
        Table users
    </caption>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>
    <% for (User user : UserService.getInstance().getAll()) { %>
    <tr>
        <td><%=user.getId()%>
        </td>
        <td><%=user.getLogin()%>
        </td>
    </tr>
    <% } %>
</table>

<form action="<%=request.getContextPath()%>/user" method="post">
    Id: <input name="id" type="text">
    Name: <input name="name" type="text">
    <input type="submit" name="send">
</form>

</body>
</html>
