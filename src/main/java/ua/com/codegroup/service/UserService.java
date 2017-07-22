package ua.com.codegroup.service;

import ua.com.codegroup.entity.User;

public interface UserService {

    void save(User user);
    User findByName (String username);

}
