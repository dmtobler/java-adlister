<%--
  Created by IntelliJ IDEA.
  User: danielletobler
  Date: 4/21/20
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    if(request.getMethod().equalsIgnoreCase("post")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ((username.equals("admin") && password.equals("password"))) {
            session.setAttribute("username", username);
            response.sendRedirect("/profile.jsp");
        } else
            response.sendRedirect("/login.jsp");
    }
%>

<html>
<head>
    <title>Login</title>
    <%@ include file="/partials/head.jsp" %>
</head>
<body>

<%@ include file="/partials/navbar.jsp" %>

<%@ include file="/partials/login-form.jsp" %>

</body>
</html>