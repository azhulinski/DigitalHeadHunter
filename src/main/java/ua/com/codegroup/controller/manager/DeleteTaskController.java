package ua.com.codegroup.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.codegroup.service.UserTaskToDoService;

@Controller
public class DeleteTaskController {

    @Autowired
    UserTaskToDoService userTaskToDoService;

    @PostMapping("/depmanager/deleteTask")
    public String deleteUserTask(@RequestParam ("taskId") int id) {

        userTaskToDoService.delete(id);

        return "/depmanager/main";
    }
}
