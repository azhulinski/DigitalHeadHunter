<%@include file="tmp/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
<h3>${department.name}</h3>
<ul>
    <c:forEach items="${department.user}" var="user">
        <li>${user.username}</li>
    </c:forEach>
</ul>
<table>
    <tr>
        <td><a href="/admin/main">to main admin page</a></td>
    </tr>
</table>
</body>
</html>
