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
    <div class="form-group">
        <div class="col-sm-9">
            <h2 class="form-horizontal">saved successfully</h2>
        </div>
        <meta http-equiv="refresh" content="2;/depmanager/main/">
    </div>
</div>

</body>
</html>
