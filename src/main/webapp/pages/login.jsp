<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>

    <title>login page</title>

    <!-- Bootstrap core CSS -->
    <link href="${contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/vendor/bootstrap/css/common.css" rel="stylesheet">

    <style>
        body {
            padding-top: 54px;
            background: silver;
        }

        @media (min-width: 992px) {
            body {
                padding-top: 56px;
            }
        }

    </style>

</head>

<body>
<div class="wrapper">
    <form class="form-signin" action="/login" method="post">
        <h2 class="form-signin-heading">Please login</h2>
        <input type="text" class="form-control" name="username" placeholder="User name" required="" autofocus=""/>
        <input type="password" class="form-control" name="password" placeholder="Password" required=""/>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>


</body>

</html>
