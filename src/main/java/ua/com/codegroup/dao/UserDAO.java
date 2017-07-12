package ua.com.codegroup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.codegroup.entity.User;


public interface UserDAO extends JpaRepository<User, Integer> {

}
