package ua.com.codegroup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.codegroup.entity.Department;

public interface DepartmentDAO extends JpaRepository<Department, Integer> {

    @Query("select d from Department d join fetch d.user where d.name =:name")
    Department findDepartmentByName(@Param("name") String name);

    /*@Query("select d from User u join u.department as d where u.department.id=:id")
    Department depsFromUser(@Param("id") int id);*/
}
