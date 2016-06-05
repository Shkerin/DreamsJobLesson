<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 22.03.16
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>
    <c:forEach items="${cookie}" var="currentCookies">
        <c:if test="${currentCookies.value.name == 'color'}">
            <style>
                body {
                    background-color: ${currentCookies.value.value}
                }
            </style>
        </c:if>
    </c:forEach>
</head>
<body>

Welcome back, ${sessionScope.login}, ${sessionScope.role} <a href="${pageContext.servletContext.contextPath}/logout">logout</a>
<div>Users</div>
<table>
    <caption>
        Table users
    </caption>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
        </tr>
    </c:forEach>
</table>

<form action="${pageContext.servletContext.contextPath}/user" method="post">
    Id: <input name="id" type="text">
    Name: <input name="name" type="text">
    <input type="submit" name="send">
</form>

</body>
</html>
