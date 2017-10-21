<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>

    <title>main admin page</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <%-- <link href="${contextPath}/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">--%>


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
                <c:forEach items="${departments}" var="department">
                    <li><a href="${department.name}">${department.name}</a></li>
                </c:forEach>
                <hr>
                <li><a href="/admin/main">main admin page</a></li>
            </ul>
            <br>
        </div>
    </div>
</div>
</body>
</html>
