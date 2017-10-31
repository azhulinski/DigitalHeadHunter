package ua.com.codegroup.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.codegroup.service.DepartmentService;

@Controller
public class DeleteDepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/admin/deleteDepartment")
    public String deleteDepartment(@RequestParam("id") int id) {

        departmentService.delete(id);

        return "redirect:/admin/viewAllDepartments";
    }

}
