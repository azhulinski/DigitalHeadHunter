<%@include file="tmp/header.jsp" %>
<body>

<h3>${user.username}</h3>

<c:forEach items="${user.userTaskToDo}" var="task">
    <li>
        <a href="${task.taskName}-detail">${task.taskName}</a>
    </li>
</c:forEach>

</body>
</html>
