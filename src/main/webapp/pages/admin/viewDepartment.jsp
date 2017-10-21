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
                <li><a href="/">to index page</a></li>
                <hr>
                <form action="/admin/deleteDepartment" method="post">
                    <input type="hidden" value="${dep.id}" name="id">
                    <input type="submit" class="btn btn-primary btn-block" name="" value="delete department">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </ul>
            <br>
        </div>
        <div class="col-sm-9">
            <ul>
                <c:forEach items="${dep.user}" var="user">
                    <li><a href="${user.username}-info"><h2>${user.username}</h2></a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
</body>
</html>


<%--

<%@include file="tmp/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
<h3>${department.name}</h3>
<ul>
    <c:forEach items="${department.user}" var="user">
        <li><a href="${user.username}-info">${user.username}</a></li>
    </c:forEach>
</ul>
<table>
    <tr>
        <td><a href="/admin/main">to main admin page</a></td>
    </tr>

    <tr>
        <td>
            <form action="/admin/deleteDepartment" method="post">
                <input type="text" value="${department.id}" name="id">
                <input type="submit" name="" value="delete department">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
--%>