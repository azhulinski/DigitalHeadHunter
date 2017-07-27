<%@include file="tmp/header.jsp"%>
<body>

<table>
    <tr>
        <td><a href="/admin/newWorker">add new worker</a></td>
    </tr>
    <tr>
        <td><a href="/admin/newDepartment">add new department</a></td>
    </tr>

    <tr>
        <td><a href="/">to index page</a></td>
    </tr>

</table>

</body>
<div class="footer">
    <hr>
    <a href="/logout">logout</a>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

</div>
</html>
