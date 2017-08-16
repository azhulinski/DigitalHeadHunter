<%@include file="tmp/header.jsp" %>


<body>
<h3>${userName}</h3>

<form action="/user/updateInfo" method="post">
    <table>
        <tr>
            <td>
                <input type="hidden" value="${id}" name="user">
            </td>
        </tr>
        <tr>
            <td><input type="text" value="${firstName}" onclick="this.value='';" name="firstName"></td>

        </tr>
        <tr>
            <td><input type="text" value="${lastName}" onclick="this.value='';" name="lastName"></td>

        </tr>
        <tr>
            <td>
                <script>
                    $(function () {
                        $("#datepicker").datepicker({dateFormat: 'dd.mm.yy', changeMonth: true, changeYear: true});
                    });
                </script>
                <fmt:formatDate value="${UserDetailedInfo.dateOfBirth}" var="dateString" pattern="dd.mm.yyyy"/>

                <input type="text" path="dateOfBirth" value="${dateString}" id="datepicker" name="dateOfBirth">

            </td>
        </tr>
        <tr>
            <td><select id="gender" name="gender">
                <option value="male">male</option>
                <option value="female">female</option>
            </select></td>
            <td>gender</td>
        </tr>
        <tr>
            <td>
                <input type="checkbox" name="married" checked>
            </td>
            <td>
                married
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="update info"></td>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </tr>
    </table>
</form>


</body>
</html>
