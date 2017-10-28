<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>change password</title>

    <link href="${contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/vendor/bootstrap/css/common.css" rel="stylesheet">
    <link rel="stylesheet" href="/marker/main.css">

    <style>
        body {
            padding-top: 54px;
            background: silver;
        }

    </style>

</head>

<body>

<div class="container">
    <form class="form-horizontal" role="form" action="/user/changePassword/" method="post">
        <h2>changing default password</h2>
        <div class="form-group">
            <div class="col-sm-9">
                <input type="hidden" value="${userId}" name="id" >
                <p><input type="password" name="password" class="form-control"></p>
                <p><input type="submit" value="change password" class="btn btn-primary btn-block"></p>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            </div>
        </div>


    </form>
</div>
</body>
</html>


<%--
<body>

<form action="/user/changePassword/" method="post">
    <input type="hidden" value="${userId}" name="id">
    <input type="password" name="password">
    <input type="submit" value="change password">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

</body>
</html>
--%>
