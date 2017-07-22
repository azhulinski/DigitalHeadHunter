package ua.com.codegroup.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.com.codegroup.entity.Department;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.service.DepartmentService;
import ua.com.codegroup.service.Editors.DepartmentEditor;
import ua.com.codegroup.service.UserService;

@Controller
public class AdminPageController {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentEditor departmentEditor;

    @GetMapping("/admin/main")
    public String mainAdminPage() {

        return "admin/main";
    }

    @GetMapping("/admin/newWorker")
    public String addNewWorker(Model model) {
        model.addAttribute("listOfDepartments", new User());
        model.addAttribute("departments", departmentService.findAll());
        return "admin/newWorker";
    }

    @InitBinder("listOfDepartments")
    public void binder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Department.class, departmentEditor);
    }


    @PostMapping("/admin/newWorker")
    public String addNewWorker(@ModelAttribute ("listOfDepartments") @Validated User user, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "admin/newWorker";
        }
        userService.save(user);

        return "/admin/tmp/success";
    }

    @GetMapping("/admin/newDepartment")
    public String newDepartment() {
        return "/admin/newDepartment";
    }

    @PostMapping("/admin/newDepartment")
    public String newDepartment(@RequestParam String name) {
        Department department = new Department();
        department.setName(name);
        departmentService.save(department);

        return "admin/tmp/success";
    }
}
