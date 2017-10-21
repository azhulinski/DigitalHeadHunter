<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>user information</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
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
            background-color: #555;
            color: grey;
            padding: 15px;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
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
            <%-- <ul class="nav navbar-nav">
                 <li class="active"><a href="#">Home</a></li>
                 <li><a href="#">About</a></li>
                 <li><a href="#">Projects</a></li>
                 <li><a href="#">Contact</a></li>
             </ul>--%>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <p><a href="/">to index page</a></p>
            <p><a href="/admin/main">main admin page</a></p>
            <p><a href="/admin/${user.username}-changeAuthorities">change authorities</a></p>
            <hr>
            <p>
            <form action="/admin/resetPassword" method="post">
                <input type="hidden" value="${userId}" name="userId">
                <input type="submit" class="btn btn-primary btn-block" name="" value="reset password">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
            </p>
            <p>
            <form action="/admin/deleteUser" method="post">
                <input type="hidden" value="${user.id}" name="userId">
                <input type="submit" class="btn btn-primary btn-block" name="" value="delete user">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
            </p>
        </div>
        <div class="col-sm-8 text-left">
            <h4>${authorities}</h4>
            <ul class="list-group">
                <li class="list-group-item">${firstName}</li>

                <li class="list-group-item">${lastName}</li>
               <hr>
                        <h4>${dateOfBirth}</h4>


                        <h4>${gender}</h4>


                    <c:if test="${!married}">
                        <td>
                            <h4>not married</h4>
                        </td>
                    </c:if>
                    <c:if test="${married}">
                        <td>
                            <h4>married</h4>
                        </td>
                    </c:if>
                </tr>
            </ul>

        </div>
        <div class="col-sm-2 sidenav">
            <div class="well">
                <p><img src="${avatar}" alt="avatar" width="80" height="80"></p>
            </div>

        </div>
    </div>
</div>

</body>
</html>


<%--

<body>
<h3></h3>



    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <tr>
            <td>

                <a href="/admin/${user.username}-changeAuthorities">
                    <input type="button" value="change authorities"></a>
            </td>
        <tr/>
        <tr>
            <td>
                <form action="/admin/resetPassword" method="post">
                    <input type="hidden" value="${userId}" name="userId">
                    <input type="submit" name="" value="reset password">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <form action="/admin/deleteUser" method="post">
                    <input type="hidden" value="${user.id}" name="userId">
                    <input type="submit" name="" value="delete user">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                </form>
            </td>
        </tr>
    </sec:authorize>

</table>

</body>
</html>
--%>
