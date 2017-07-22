package ua.com.codegroup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.codegroup.dao.DepartmentDAO;
import ua.com.codegroup.entity.Department;
import ua.com.codegroup.service.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentDAO departmentDAO;


    public void save(Department department) {
        departmentDAO.save(department);

    }

    public List<Department> findAll() {
        return departmentDAO.findAll();
    }

    public Department findOne(int id) {
        return departmentDAO.findOne(id);
    }

    public void delete(int id) {
        departmentDAO.delete(id);

    }
}
