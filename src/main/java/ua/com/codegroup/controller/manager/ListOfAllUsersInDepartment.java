package ua.com.codegroup.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.codegroup.entity.Department;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.service.DepartmentService;
import ua.com.codegroup.service.UserService;

import java.security.Principal;

@Controller
public class ListOfAllUsersInDepartment {

    @Autowired
    UserService userService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/depmanager/{name}")
    public String viewUsers(@PathVariable("name") String name,
                            Model model,
                            Principal principal) {

        User manager = userService.findByName(principal.getName());

        model.addAttribute("manager", manager);
        model.addAttribute("avatar", manager.getAvatar());

        model.addAttribute("departments", departmentService.findAll());
        Department one = departmentService.findDepartmentByName(name);
        model.addAttribute("dep", one);

        return "/depmanager/viewdepartment";
    }


}
