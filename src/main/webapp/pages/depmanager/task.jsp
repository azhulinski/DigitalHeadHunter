<%@include file="tmp/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>

tasks for ${userInfo.firstName} ${userInfo.lastName}
<br>
task name - ${task.taskName}
<br>
${task.taskBody}


</body>
</html>
