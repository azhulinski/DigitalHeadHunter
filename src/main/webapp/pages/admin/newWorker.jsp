<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>new worker page</title>

    <link href="${contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/vendor/bootstrap/css/common.css" rel="stylesheet">
    <link rel="stylesheet" href="/marker/main.css">

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

<div class="container">
    <sf:form class="form-horizontal"
             role="form"
             action="/admin/newWorker"
             method="post"
             modelAttribute="saveNewUser">
        <h2>User registering form</h2>
        <div class="form-group">
            <div class="col-sm-9">
                <sf:input path="username" id="username" placeholder="user name" class="form-control"
                          autofocus="autofocus"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-9">
                <sf:input path="password" id="password" placeholder="password" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="department" class="col-sm-3 control-label">Department</label>
            <div class="col-sm-9">
                <sf:select path="department" id="department" class="form-control">
                    <c:forEach items="${departments}" var="department">
                        <sf:option value="${department.id}">${department.name}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
                <button type="submit" class="btn btn-primary btn-block">Register</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </div>
        </div>
    </sf:form>
</div>
</body>
</html>