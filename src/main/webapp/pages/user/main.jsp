<%@include file="tmp/header.jsp" %>
<body>

<table>
    <tr>
        <td>
            <a href="/user/${user}">view your details</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/user/addUserDetails">edit details</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/logout">logout</a>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </td>
    </tr>
</table>
<hr>


<div class="footer">
    <hr>


</div>

</body>
</html>
