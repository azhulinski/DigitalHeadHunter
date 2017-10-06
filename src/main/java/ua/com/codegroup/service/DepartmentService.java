package ua.com.codegroup.service;

import org.springframework.stereotype.Service;
import ua.com.codegroup.entity.Department;

import java.util.List;

@Service
public interface DepartmentService {

    void save(Department department);

    List<Department> findAll();

    Department findOne(int id);

    void delete(int id);

    Department findDepartmentByName (String name);


}
