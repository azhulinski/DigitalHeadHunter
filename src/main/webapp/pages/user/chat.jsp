<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/resources/sockjs.js"></script>
    <script src="/resources/stomp.js"></script>
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
</head>
<body>

<div>
    <button id="connect" onclick="connect()">connect</button>
    <button id="disconnect" disabled = "disabled" onclick="disconnect()">disconnect</button>
</div>

<div id="conversationDiv">
    <input type="text" id="name">
    <button id="send" onclick="send()">send</button>
    <p id="response"></p>
</div>
</body>
</html>
