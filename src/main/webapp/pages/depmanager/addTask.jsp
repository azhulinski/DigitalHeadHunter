<%@include file="tmp/header.jsp" %>


<body>

<h3>New task to ${user.username}</h3>
<form action="/depmanager/addTask" method="post">
    <table>

        <td>
            <input type="hidden" value="${userId}" name="id">
        </td>

        <tr>
            <td>
                <input type="text" placeholder="task name" name="taskName">
            </td>
        </tr>
        <tr>
            <td>
                <textarea name="taskBody" placeholder="input task here" cols="40" rows="4"></textarea>
            </td>
        </tr>

        <tr>
            <td>
                <input type="date" placeholder="date expired" name="endDate">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </td>
            <td>
                <input type="reset">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
