<%@include file="tmp/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
<c:forEach items="${departments}" var="department">
    <table>
        <tr>
            <td>
                <a href="${department.name}"><h2>${department.name}</h2></a>
            </td>
        </tr>
    </table>
    <hr>
</c:forEach>
<table>
    <tr>
        <td><a href="/depmanager/main">to main manager page</a></td>
    </tr>
</table>
</body>
</html>