<%@include file="tmp/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<body>
<h3>${userName}</h3>
<form action="/user/updateUserDetails/" method="post" modelAttribute="userDetailedInfo">
    <table>
        <tr>
            <td>
                <input type="hidden" value="${detailedInfoId}" name="detailedInfoId">
            </td>
        </tr>
        <tr>
            <td><input type="text" placeholder="${firstName}" name="firstName"></td>

        </tr>
        <tr>
            <td><input type="text" placeholder="${lastName}" name="lastName"></td>

        </tr>
        <tr>
            <td>
                <%--<script>
                    $(function () {
                        $("#datepicker").datepicker({dateFormat: 'mm-dd-yy', changeMonth: true, changeYear: true});
                    });
                </script>
                <fmt:formatDate type="both" value="${dateOfBirth}" var="dateString"/>--%>

                <input type="date" path="dateOfBirth" placeholder="dateOfBirth" name="dateOfBirth">

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
                <input type="hidden" value='0' name="married">
                <input type="checkbox" value='1' name="married">
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
