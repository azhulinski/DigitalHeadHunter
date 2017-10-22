package ua.com.codegroup.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.codegroup.entity.Department;
import ua.com.codegroup.service.DepartmentService;

@Controller
public class ListOfAllUsersInDepartment {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/depmanager/{name}")
    public String viewUsers(@PathVariable("name") String name, Model model){

        Department department = departmentService.findDepartmentByName(name);
        model.addAttribute("departments", departmentService.findAll());

        model.addAttribute("department", department);

        return "/depmanager/viewdepartment";
    }


}
