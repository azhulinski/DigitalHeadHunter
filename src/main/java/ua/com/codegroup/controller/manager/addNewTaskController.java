package ua.com.codegroup.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.entity.UserTaskToDo;
import ua.com.codegroup.service.DepartmentService;
import ua.com.codegroup.service.UserService;
import ua.com.codegroup.service.UserTaskToDoService;

@Controller
public class addNewTaskController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    UserService userService;

    @Autowired
    UserTaskToDoService userTaskToDoService;

    @GetMapping("depmanager/listOfAllUsers")
    public String addNewTask(Model model) {

        model.addAttribute("users", userService.findAll());


        return "depmanager/listOfAllUsers";
    }

    @GetMapping("/depmanager/{user}-task")
    public String addTaskToUser(@PathVariable("user") String name, Model model) {

        User user = userService.findByName(name);

        model.addAttribute("user", user);
        model.addAttribute("userId", user.getId());

        return "/depmanager/addTask";
    }



    @PostMapping("/depmanager/addTask")
    public String addTaskToUser(@RequestParam String taskName,
                                @RequestParam String taskBody,
                                @RequestParam int id) {

        User user = userService.findOne(id);

        UserTaskToDo task = new UserTaskToDo();

        task.setTaskName(taskName);
        task.setTaskBody(taskBody);
        task.setCompleted(false);
        task.setUser(user);

        userTaskToDoService.save(task);


        return "depmanager/tmp/success";
    }

}
