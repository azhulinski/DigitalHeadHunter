<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <script src="resources/sockjs.js"></script>
    <script src="resources/stomp.js"></script>
    <title>corporate chat</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <style>
        textarea {
            resize: none;
        }

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
            <h5 class="navbar-brand">main chat room</h5>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">

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
            <p></p>
            <hr>

        </div>

        <div class="col-sm-8 text-left">
            <p id="response"></p>
        </div>
        <div class="col-sm-2 sidenav">
            <div>
                <p><img src="${avatar}" alt="avatar" class="widthSet"></p>
            </div>
            <div>
                <button class="btn btn-primary" id="connect" onclick="connect()">connect</button>
                <button class="btn btn-primary" id="disconnect" disabled="disabled" onclick="disconnect()">disconnect
                </button>
            </div>


        </div>
    </div>
</div>
<hr>
<footer class="container-fluid text-center">
    <div id="conversationDiv">
        <div class="col-sm-10 text-left">
            <input class="form-control" type="text" autocomplete="off" id="name">
        </div>
        <div class="col-sm-1 text-right">
            <button class="btn btn-primary" id="send" onclick="send()">send</button>
        </div>
    </div>
</footer>

</body>
<script>
    var stompClient = null;

    function connect() {
        var socket = new SockJS('/hello');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            setConnected(true);

            stompClient.subscribe('/topic/greetings', function (greeting) {
                showGreeting(JSON.parse(greeting.body).content)
            })
        })
    }

    function setConnected(connected) {
        document.getElementById("connect").disabled = connected;
        document.getElementById("disconnect").disabled = !connected;
        document.getElementById("conversationDiv").visibility = connected ? 'visible' : 'hidden';
        document.getElementById('response').innerHTML = '';
    }

    function showGreeting(message) {
        var response = document.getElementById('response');
        var p = document.createElement('p');
        p.style.wordWrap = "break-word";
        p.appendChild(document.createTextNode(message));
        response.appendChild(p);
        document.getElementById('name').value = '';
    }

    function disconnect() {
        stompClient.disconnect();
        setConnected(false);
    }

    function send() {
        var name = document.getElementById("name").value;
        stompClient.send("/app/hello", {}, JSON.stringify({'name': name}));
    }
</script>
</html>