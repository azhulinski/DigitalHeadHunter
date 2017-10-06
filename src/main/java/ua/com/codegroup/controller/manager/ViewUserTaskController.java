package ua.com.codegroup.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewUserTaskController {


    @GetMapping("/depmanager/{name}-viewtasks")
    public String viewUserTasksController(@PathVariable("name") String name, Model model) {

        return "/depmanager/viewusertasks";
    }

}
