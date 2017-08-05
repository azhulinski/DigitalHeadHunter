<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="tmp/header.jsp" %>

<body>
<h1>Welcome to index page</h1>

<table>
    <sec:authorize access="isAnonymous()">
    <tr>
        <td>
            <a href="/toLogin">login page</a>
        </td>
    </tr>
    </sec:authorize>

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <tr>
            <td><a href="admin/main">admin page</a></td>
        <tr/>
        <tr>
            <td><a href="admin/viewAllDepartments">view all departments</a></td>
        </tr>
    </sec:authorize>


    <sec:authorize access="hasRole('ROLE_USER')">
        <tr>
            <td>
                <a href="user/main">user main page</a>
            </td>

        </tr>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <tr>
            <td>
                <a href="/logout">logout</a>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </td>
        </tr>
    </sec:authorize>
</table>


<div class="footer">

    <hr>
    time on server: ${serverTime}

</div>

</body>
</html>
