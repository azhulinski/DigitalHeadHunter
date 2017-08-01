<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="tmp/header.jsp" %>

<body>

<form action="/user/adduserdetails" method="post">
    <table>
        <tr>
            <td><input type="text" name="firstName"></td>
            <td>first name</td>
        </tr>
        <tr>
            <td><input type="text" name="lastName"></td>
            <td>last name</td>
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
            <td>date of birth</td>
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
                <input type="checkbox" value="gender" name="gender">
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
