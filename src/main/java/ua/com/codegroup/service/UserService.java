package ua.com.codegroup.service;

import org.springframework.stereotype.Service;
import ua.com.codegroup.entity.User;

import java.util.List;

@Service
public interface UserService {

    void save(User user);

    List<User> findAll();

    User findOne(int id);

    void delete(int id);

    User findByName (String username);


}
