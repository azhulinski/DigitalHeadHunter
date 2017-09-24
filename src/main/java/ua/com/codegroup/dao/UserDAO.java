package ua.com.codegroup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.codegroup.entity.User;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.username =:username")
    User findByUsername(@Param("username") String username);

    @Query("select u from User u join fetch u.department where u.department.id=:id")
    List<User> findAllUsersByDepartmentId(@Param("id") int id);

}