package ua.com.codegroup.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.com.codegroup.entity.User;
import ua.com.codegroup.service.DepartmentService;
import ua.com.codegroup.service.UserService;

import java.security.Principal;

@Controller
public class ViewAllDepartmentsController {

    @Autowired
    UserService userService;

    @Autowired
    DepartmentService departmentService;


    @GetMapping("depmanager/viewAllDepartments")

    public String viewAllDepartments(Model model) {

            model.addAttribute("departments", departmentService.findAll());

        return "depmanager/viewAllDepartments";
    }

}
