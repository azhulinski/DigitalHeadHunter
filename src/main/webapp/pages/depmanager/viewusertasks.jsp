<%@include file="tmp/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>

<h3>User ${user.username}</h3>

<c:forEach items="${user.userTaskToDo}" var="task">
    <li>
        <a href="${task.taskName}-details">${task.taskName}</a>
    </li>
</c:forEach>

</body>
</html>
