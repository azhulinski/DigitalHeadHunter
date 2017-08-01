package ua.com.codegroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        return "/admin/tmp/success";
    }

    @GetMapping("/admin/viewAllDepartments")
    public String viewAllDepartments(Model model) {
        model.addAttribute("departments", departmentService.findAll());
        return "/admin/viewAllDepartments";
    }

    @GetMapping("/admin/{name}")
    public String showDepartment(@PathVariable("name") String name, Model model) {
        Department one = departmentService.findDepartmentByName(name);
        model.addAttribute("department", one);
        return "/admin/viewDepartment";
    }

    @GetMapping("/admin/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "/";
    }
}
