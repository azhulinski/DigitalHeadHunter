<%@include file="tmp/header.jsp" %>
<body>

<c:forEach items="${users}" var="user">
    <table>
        <tr>
            <li><a href="${user.username}-task">${user.username}</a></li>
            <td>
            </td>
        </tr>
        <tr>
            <td>

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
