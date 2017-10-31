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

        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {
            height: 450px
        }

        /* Set gray background color and 100% height */
        .sidenav {
            padding-top: 20px;
            background-color: #2b2b2b;
            height: 100%;
        }

        /* Set black background color, white text and some padding */
        footer {
            position: fixed;
            right: 0;
            bottom: 0;
            left: 0;
            text-align: center;
            background-color: #2b2b2b;
            color: cadetblue;
            padding: 15px;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */
        @media /*screen and (max-width: 767px)*/ {
            .sidenav {
                height: auto;
                padding: 15px;
            }

            .row.content {
                height: auto;
            }
        }
    </style>

</head>

<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <h5 class="navbar-brand">${user.username}</h5>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <sec:authorize access="isAuthenticated()">
                <ul class="nav navbar-nav navbar-right">

                    <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                </ul>
            </sec:authorize>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <ul class="nav nav-pills nav-stacked">
                <li><a href="/admin/newWorker">add new worker</a></li>
                <li><a href="/admin/newDepartment">add new department</a></li>
                <li><a href="/">to index page</a></li>
                <hr>
                <li>
                    <a href="/admin/viewAllDepartments">view all departments</a>
                </li>
            </ul>

        </div>
    </div>
</div>
<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>

</body>
</html>