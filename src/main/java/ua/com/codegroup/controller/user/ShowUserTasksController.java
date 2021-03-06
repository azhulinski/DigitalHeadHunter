package ua.com.codegroup.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.entity.UserDetailedInfo;
import ua.com.codegroup.entity.UserTaskToDo;
import ua.com.codegroup.service.UserDetailedInfoService;
import ua.com.codegroup.service.UserService;
import ua.com.codegroup.service.UserTaskToDoService;

import java.security.Principal;

@Controller
public class ShowUserTasksController {

    @Autowired
    UserService userService;

    @Autowired
    UserDetailedInfoService userDetailedInfoService;

    @Autowired
    UserTaskToDoService userTaskToDoService;

    @GetMapping("/user/showTasks")
    public String showAllTasks(Principal principal, Model model) {

        User user = userService.findByName(principal.getName());

        model.addAttribute("user", user);


        return "/user/showTasks";
    }

    @GetMapping("/user/{taskName}-detail")
    public String viewTask(@PathVariable("taskName") String taskName, Model model) {

        UserTaskToDo userTaskToDo = userTaskToDoService.oneTask(taskName);

        User user = userTaskToDo.getUser();

        UserDetailedInfo userInfo = userDetailedInfoService.findDetailsByUserId(user.getId());

        model.addAttribute("user", user);
        model.addAttribute("task", userTaskToDo);
        model.addAttribute("completed", userTaskToDo.isCompleted());
        model.addAttribute("userInfo", userInfo);


        return "user/viewTask";
    }

}
