package ua.com.codegroup.controller.manager;

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

import java.util.List;

@Controller
public class ViewUserTaskController {

    @Autowired
    UserService userService;

    @Autowired
    UserDetailedInfoService userDetailedInfoService;

    @Autowired
    UserTaskToDoService userTaskToDoService;


    @GetMapping("/depmanager/{name}-viewtasks")
    public String viewUserTasksController(@PathVariable("name") String name, Model model) {

        User user = userService.findByName(name);

        model.addAttribute("user", user);

        return "/depmanager/viewusertasks";
    }

    @GetMapping("depmanager/{taskname}-details")
    public String viewUsrTaskController(@PathVariable("taskname") String taskname,
                                        Model model) {

        UserTaskToDo task = userTaskToDoService.oneTask(taskname);

        UserDetailedInfo userDetailedInfo = userDetailedInfoService.findDetailsByUserId(task.getUser().getId());

        model.addAttribute("userInfo", userDetailedInfo);

        model.addAttribute("task", task);

        return "/depmanager/task";
    }

}
