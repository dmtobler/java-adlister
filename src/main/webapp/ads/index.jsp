<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: danielletobler
  Date: 4/23/20
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ads</title>
    <%@ include file="../partials/head.jsp"%>
</head>
<body>
<%@ include file="../partials/navbar.jsp"%>

<div class="jumbotron">
<h1 class="display-4">Current Listings</h1>
</div>

<c:forEach var="ad" items="${ads}">
    <div class="card card-body">
        <h2 class="card-title">${ad.title}</h2>
        <p class="card-text">${ad.description}</p>
    </div>
</c:forEach>

</body>
</html>
