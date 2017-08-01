<%@include file="tmp/header.jsp" %>
<body>

<c:forEach items="${departments}" var="department">
    <table>
        <tr>
            <td>
                <h1>${department.id}</h1>
            </td>
            <td>
                <a href="${department.name}"><h1>${department.name}</h1></a>
            </td>
        </tr>
    </table>
    <hr>
</c:forEach>

</body>
</html>
