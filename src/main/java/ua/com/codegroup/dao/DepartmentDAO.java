package ua.com.codegroup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.codegroup.entity.Department;

public interface DepartmentDAO extends JpaRepository<Department, Integer> {

}
