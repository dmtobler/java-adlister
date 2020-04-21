<form id="login" method="POST" action="${pageContext.request.contextPath}/login.jsp">
    <h1>Login</h1>
    <br /><label for="username">Username: </label>
    <input id="username" name="username" type="text" />
    <br /><label for="password">Password: </label>
    <input id="password" name="password" type="password" />
    <br /><button type="submit">Log in</button>
</form>