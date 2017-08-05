<%@include file="tmp/header.jsp" %>
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

</body>
</html>
