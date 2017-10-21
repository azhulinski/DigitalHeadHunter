<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>

    <title>main admin page</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


    <style>
        body {
            background: silver;
        }

        .row.content {
            height: 1500px
        }

        .sidenav {
            background-color: #2b2b2b;
            height: 100%;
        }

    </style>

</head>

<body>

<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <ul class="nav nav-pills nav-stacked">
                <li><a href="/admin/newWorker">add new worker</a></li>
                <li><a href="/admin/newDepartment">add new department</a></li>
                <li><a href="/">to index page</a></li>
                <sec:authorize access="isAuthenticated()">
                    <li><a class="nav-link active" href="/logout">logOut</a></li>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </sec:authorize>
            </ul>
            <br>

        </div>
    </div>
</div>

</body>
</html>