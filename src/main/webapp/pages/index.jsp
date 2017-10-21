<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>index page</title>

    <!-- Bootstrap core CSS -->
    <link href="${contextPath}/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
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

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">

    <div class="container">
        <sec:authorize access="isAnonymous()">
            <a class="navbar-brand" href="/toLogin">to login page</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                    aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </sec:authorize>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="admin/main">Admin Page
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="admin/viewAllDepartments">Departments</a>
                    </li>
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link active" href="/logout">logOut</a>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </li>
                    </sec:authorize>
                </ul>
            </div>
        </sec:authorize>
    </div>
</nav>
<!-- Bootstrap core JavaScript -->
<script src="${contextPath}/vendor/jquery/jquery.min.js"></script>
<script src="${contextPath}/vendor/popper/popper.min.js"></script>
<script src="${contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>
