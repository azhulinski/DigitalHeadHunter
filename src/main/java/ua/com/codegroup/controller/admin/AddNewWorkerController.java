package ua.com.codegroup.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.codegroup.entity.Department;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.service.DepartmentService;
import ua.com.codegroup.service.Editors.DepartmentEditor;
import ua.com.codegroup.service.UserService;

import java.io.File;

@Controller
public class AddNewWorkerController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    DepartmentEditor departmentEditor;

    @Autowired
    UserService userService;


    @GetMapping("/admin/newWorker")
    public String addNewWorker(Model model) {
        model.addAttribute("saveNewUser", new User());
        model.addAttribute("departments", departmentService.findAll());


        return "/admin/newWorker";
    }

    @InitBinder
    public void binder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Department.class, departmentEditor);
    }

    @PostMapping("/admin/newWorker")
    public String addNewWorker(@Validated User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return "/admin/newWorker";

        }

        user.setAvatar("/img/man.png");

        userService.save(user);

        return "/admin/tmp/success";
    }

}