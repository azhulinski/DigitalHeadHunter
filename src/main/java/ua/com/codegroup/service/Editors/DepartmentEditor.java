package ua.com.codegroup.service.Editors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.codegroup.entity.Department;
import ua.com.codegroup.service.DepartmentService;

import java.beans.PropertyEditorSupport;

@Component
public class DepartmentEditor extends PropertyEditorSupport {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void setAsText(String idOfDepartment) throws IllegalArgumentException {
        int id = Integer.parseInt(idOfDepartment);
        Department one = departmentService.findOne(id);
        setValue(one);

    }
}
