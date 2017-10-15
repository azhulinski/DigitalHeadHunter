package ua.com.codegroup.controller.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.codegroup.entity.UserTaskToDo;
import ua.com.codegroup.service.UserTaskToDoService;

@Controller
public class ConfirmTaskCompletingController {

    @Autowired
    UserTaskToDoService taskToDoService;

    @PostMapping("/depmanager/confirmTask")
    public String confirmTask(@RequestParam("taskId") int id) {

        UserTaskToDo userTaskToDo = taskToDoService.findOne(id);

        userTaskToDo.setConfirmed(true);

        taskToDoService.save(userTaskToDo);

        return "redirect:/";
    }

}
