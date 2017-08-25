<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="tmp/header.jsp"%>
<body>

<form action="/login" method="post">
    <input type="text" placeholder="username" name="username">
    <input type="password" placeholder="password" name="password" >

    <input type="submit">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

</form>

<div class="footer">

    <hr>
    time on server: ${serverTime}

</div>

</body>
</html>
