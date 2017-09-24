<%@include file="tmp/header.jsp"%>
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
