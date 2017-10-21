<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>new department page</title>

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
    <form class="form-horizontal" role="form" action="/admin/newDepartment" method="post">
        <h2>new department form</h2>
        <div class="form-group">
            <div class="col-sm-9">
                <input type="text" id="name" placeholder="department name" class="form-control"
                       autofocus name="name" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
                <button type="submit" class="btn btn-primary btn-block">Register</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </div>
        </div>
    </form>
</div>
</body>
</html>