<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>task detail</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }

            .row.content {
                height: auto;
            }
        }
        .widthSet {
            max-width: 205px;
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

            <img src="${avatar}" alt="avatar" width="72" height="72">
            <h5 class="navbar-brand">${manager.username}</h5>

        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <sec:authorize access="isAuthenticated()">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                </ul>
            </sec:authorize>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">

            <c:forEach items="${user.userTaskToDo}" var="task">

                <a href="${task.taskName}-detail">${task.taskName}</a>

            </c:forEach>
            <hr>

            <p><a href="/user/showTasks">back</a></p>


            <p></p>
            <p><a href="/chat">chat room</a></p>
            <hr>
            <p><a href="/">index page</a></p>
        </div>
        <div class="col-sm-8 text-left">
            <h1>${task.taskName}</h1>
            <hr>
            <ul>


            </ul>
            <div class="col-sm-8 text-left">

                <ul class="list-group">
                    <li class="list-group-item">${task.taskName}</li>

                    <li class="list-group-item">${task.taskBody}</li>

                    <li id="expired" class="list-group-item"></li>
                    <hr>

                </ul>

                <form>
                    <input type="hidden" value="${task.id}" name="taskId">
                    <button id="button"
                            class="btn btn btn-primary col-sm-4"
                            formaction="/user/completeTask"
                            formmethod="post">complete
                    </button>
                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>

                </form>

            </div>

        </div>
        <div class="col-sm-2 sidenav">

        </div>
    </div>
</div>
<hr>
<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>
<script>

    if (${completed}) {
        document.getElementById("button").disabled = true;
    }
    else {
        document.getElementById("button").disabled = false;
    }

</script>

<script>
    if (!${completed}) {

        var res = document.getElementById('expired');
        var p = document.createElement('p');

        p.appendChild(document.createTextNode('expires ${task.endDate}'));
        res.appendChild(p);
    }
</script>
</body>
</html>
