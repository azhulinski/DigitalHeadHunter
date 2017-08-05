package ua.com.codegroup.service;

import ua.com.codegroup.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> findAll();

    User findOne(int id);

    void delete(int id);

    User findByName (String username);


}
