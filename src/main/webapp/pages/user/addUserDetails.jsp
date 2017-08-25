<%@include file="tmp/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
<h3>${userName}</h3>

<form action="/user/addUserDetails" method="post" modelAttribute="addUserInfo">
    <table>
        <tr>
            <td>
                <input type="hidden" value="${userId}" name="user">
            </td>
        </tr>
        <tr>
            <td><input type="text" placeholder="first name" name="firstName"></td>
            <td>first name</td>
        </tr>
        <tr>
            <td><input type="text" placeholder="last name" name="lastName"></td>
            <td>last name</td>
        </tr>
        <tr>
            <td>
                <%--<script>
                    $(function () {
                        $("#datepicker").datepicker({dateFormat: 'MM-dd-yy', changeMonth: true, changeYear: true});
                    }); id="datepicker"
                </script>--%>
                <fmt:formatDate value="${UserDetailedInfo.dateOfBirth}"
                                var="dateString"/>

                <input type="date" path="dateOfBirth" value="${dateString}" name="dateOfBirth">

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
                <input type="hidden" value='0' name="married">
                <input type="checkbox" value='1' name="married">
            </td>
            <td>
                married
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="save info"></td>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </tr>
    </table>
</form>

</body>
</html>