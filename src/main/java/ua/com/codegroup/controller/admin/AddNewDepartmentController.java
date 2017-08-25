package ua.com.codegroup.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.codegroup.entity.Department;
import ua.com.codegroup.service.DepartmentService;

@Controller
public class AddNewDepartmentController {

    @Autowired
    DepartmentService departmentService;

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

}
