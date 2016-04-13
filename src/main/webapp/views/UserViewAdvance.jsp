<%@ page import="com.vladshkerin.models.UserAdvance" %>
<%@ page import="com.vladshkerin.services.UserServiceAdvance" %><%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 06.04.16
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserAdvanceView</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/style/UserView.css">
</head>
<body>
    <h2>UserAdvanceView</h2>
    <div>
        <%=request.getContextPath()%>
    </div>
    <table>
        <caption>Users</caption>
        <tr>
            <th class="center">Id</th>
            <th class="right">Name</th>
            <th class="right">Growth</th>
            <th class="center">Birth day</th>
            <th class="center">Children</th>
        </tr>
        <% for (UserAdvance user : UserServiceAdvance.getInstance().getAll()) { %>
        <tr>
            <td class="center"><%= user.getId() %></td>
            <td class="right"><%= user.getName() %></td>
            <td class="right"><%= user.getGrowth() %></td>
            <td class="center"><%= user.getBirthDayStr() %></td>
            <td class="center"><%= user.getChildrenStr() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
