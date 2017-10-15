package ua.com.codegroup.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.codegroup.entity.Department;
import ua.com.codegroup.service.DepartmentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AdminMainPageController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/admin/main")
    public String mainAdminPage() {

        return "/admin/main";
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