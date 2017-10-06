<%@include file="tmp/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>

<h3>User ${user.username}</h3>
<table>
    <tr>
        <td>
            <h4>${firstName}</h4>
            <h4>${authorities}</h4>
        </td>
        <td>
            <h4>${lastName}</h4>

        </td>
    <tr/>
    <tr>
        <td>
            <h4>${dateOfBirth}</h4>
        </td>
    <tr/>
    <tr>
        <td>
            <a href="/depmanager/${user.username}-viewtasks">
                <input type="button" value="view tasks">
            </a>
        </td>
    </tr>
</table>

</body>
</html>
