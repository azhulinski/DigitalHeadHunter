package ua.com.codegroup.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.codegroup.entity.UserTaskToDo;
import ua.com.codegroup.service.UserTaskToDoService;

@Controller
public class CompleteUserTaskController {

    @Autowired
    UserTaskToDoService userTaskToDoService;


    @PostMapping("/user/completeTask")
    public String confirmTask(@RequestParam("taskId") int taskId) {

        UserTaskToDo userTaskToDo = userTaskToDoService.findOne(taskId);

        userTaskToDo.setCompleted(true);
        userTaskToDoService.save(userTaskToDo);

        return "redirect:/user/showTasks";
    }

}
