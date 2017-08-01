<%@include file="tmp/header.jsp"%>
<body>

<sf:form action="/admin/newWorker" method="post" modelAttribute="listOfDepartments">
    <sf:input path="username"/>
    <sf:input path="password"/>
    <sf:select path="department">
        <c:forEach items="${departments}" var="department">
            <sf:option value="${department.id}">${department.name}</sf:option>
        </c:forEach>
    </sf:select>
    <input type="submit">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</sf:form>

</body>
</html>
