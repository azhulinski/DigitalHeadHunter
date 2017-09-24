<%@include file="tmp/header.jsp" %>
<body>

<form action="/user/changePassword/" method="post">
    <input type="hidden" value="${userId}" name="id">
    <input type="password" name="password">
    <input type="submit" value="change password">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

</body>
</html>
