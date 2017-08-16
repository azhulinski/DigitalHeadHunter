<%@include file="tmp/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
<h3>User ${user.username}</h3>
<table>
    <tr>
        <td>
            <h4>${firstName}</h4>
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
            <h4>${gender}</h4>
        </td>
    <tr/>
    <tr>
        <s:if test="${!married}">
            <td>
                <h4>not married</h4>
            </td>
        </s:if>
        <s:if test="${married}">
            <td>
                <h4>married</h4>
            </td>
        </s:if>
    </tr>
    <tr>
        <td>

                <a href="/user/editUserDetails/"><input type="button" value="update info"></a>
                <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

        </td>

    </tr>
</table>

</body>
</html>
