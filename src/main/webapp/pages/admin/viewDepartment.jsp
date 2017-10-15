<%@include file="tmp/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
<h3>${department.name}</h3>
<ul>
    <c:forEach items="${department.user}" var="user">
        <li><a href="${user.username}-info">${user.username}</a></li>
    </c:forEach>
</ul>
<table>
    <tr>
        <td><a href="/admin/main">to main admin page</a></td>
    </tr>

    <tr>
        <td>
            <form action="/admin/deleteDepartment" method="post">
                <input type="text" value="${department.id}" name="id">
                <input type="submit" name="" value="delete department">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </td>
    </tr>
</table>
</body>
</html>