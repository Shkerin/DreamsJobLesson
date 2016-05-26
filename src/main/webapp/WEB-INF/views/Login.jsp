<%--
  TODO: comment
  
  @author vlad
  @since 26.05.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%
    Object error = request.getAttribute("error.login");
    if (error != null) {
%>
<div style="background-color: red;">
    <%=error%>
</div>
<%
    }
%>

<form action="<%=request.getContextPath()%>/login" method="post">
    <div>
        login : <input type="text" name="login">
    </div>
    <div>
        password : <input type="password" name="password">
    </div>
    <div>
        <input type="submit" value="Submit">
    </div>
</form>
</body>
</html>
