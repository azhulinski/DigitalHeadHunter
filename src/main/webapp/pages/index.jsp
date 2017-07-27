<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="tmp/header.jsp" %>

<body>
<h1>Welcome to index page</h1>

<table>
    <tr>
        <td><a href="/toLogin">login page</a></td>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <td><a href="admin/main">admin page</a></td>
            <td><a href="admin/viewAllDepartments">view all departments</a></td>
        </sec:authorize>

        <td>
            <sec:authorize access="hasRole('ROLE_USER')">
                <a href="user/main">view user details</a>
            </sec:authorize>
        </td>
    </tr>

</table>
<hr>

<div class="footer">

    <hr>
    time on server: ${serverTime}

</div>

</body>
</html>
