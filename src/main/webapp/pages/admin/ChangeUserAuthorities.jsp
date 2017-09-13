<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>${user.username}</h3>

<form action="/admin/ChangeUserAuthorities" method="post">
    <input type="hidden" value="${id}" name="userId">
    <input type="submit" name="authority" value="${userAuthority}">
    <input type="submit" name="authority" value="${managerAuthority}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
