<%@include file="tmp/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>

tasks for ${userInfo.firstName} ${userInfo.lastName}
<br>
task name - ${task.taskName}
<br>
${task.taskBody}

<form action="/depmanager/confirmTask" method="post">
    <input type="hidden" value="${task.id}" name="taskId">
    <input type="submit" name="" value="confirm completing">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

</body>
</html>
