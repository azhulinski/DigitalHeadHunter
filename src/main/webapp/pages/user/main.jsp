<%@include file="tmp/header.jsp" %>
<body>

<table>
    <tr>
        <td>
            <a href="/user/${user.username}">view your details</a>
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
<form>
    <tr>
    <input type="button" value="start work" onclick="startStop(this)" name="">
    <script>
        function startStop(input) {
            input.value = input.value != 'stop work' ? 'stop work' : 'start work'
        }
    </script>
    </tr>
</form>

<div class="footer">
    <hr>


</div>

</body>
</html>
