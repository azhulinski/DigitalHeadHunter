package ua.com.codegroup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codegroup.dao.UserDAO;
import ua.com.codegroup.entity.Authority;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public User findOne(int id) {
        return userDAO.findOne(id);
    }

    public void delete(int id) {
        userDAO.delete(id);
    }

    public User findByName(String username) {
        User byUsername = userDAO.findByUsername(username);
        System.out.println(byUsername);
        return byUsername;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername");
        return findByName(username);
    }
}
