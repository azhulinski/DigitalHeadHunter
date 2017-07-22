package ua.com.codegroup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.codegroup.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {

    @Query("from User u where u.username =:username")
    User findByUsername(@Param("username") String username);

}
