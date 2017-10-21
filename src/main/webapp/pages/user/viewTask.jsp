<%@include file="tmp/header.jsp" %>
<body>
tasks for ${userInfo.firstName} ${userInfo.lastName}
<br>
task name - ${task.taskName}
<br>
${task.taskBody}


<form>
    <input type="hidden" value="${task.id}" name="taskId">
    <button id="button" formaction="/user/completeTask" formmethod="post">complete</button>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>

</form>
<script>

    if (${completed}) {
        document.getElementById("button").disabled = true;
    }
    else {
        document.getElementById("button").disabled = false;
    }

</script>
</body>
</html>
