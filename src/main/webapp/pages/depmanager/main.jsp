<%@include file="tmp/header.jsp" %>
<body>

<table>

    <tr>
        <td>
            <a href="/depmanager/allUsers">view users in department</a>
        </td>
    </tr>

    <sec:authorize access="isAuthenticated()">
        <tr>
            <td>
                <a href="/logout">logout</a>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </td>
        </tr>
    </sec:authorize>
</table>
<hr>

</body>
</html>
