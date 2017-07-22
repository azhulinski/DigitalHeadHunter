<%@include file="tmp/header.jsp"%>
<body>

<form action="/admin/newDepartment" method="post">
    <input type="text" name="name">
    <input type="submit">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>

</body>
</html>
