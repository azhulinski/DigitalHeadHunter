package ua.com.codegroup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.codegroup.entity.Authority;
import ua.com.codegroup.entity.Department;
import ua.com.codegroup.entity.User;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.username =:username")
    User findByUsername(@Param("username") String username);

    /*@Query("select d from User u join u.department as d where u.department.id=:id")
    Department depsFromUser(@Param("id") int id);*/

    @Modifying
    @Query("update User set authority=:auth where id=:id ")
    void updateAuthority(@Param("id") int id, @Param("auth") Authority auth);

    @Modifying
    @Query("update User set avatar=:avatar where id=:id")
    void updateAvatar(@Param("id") int id, @Param("avatar") String avatar);

}