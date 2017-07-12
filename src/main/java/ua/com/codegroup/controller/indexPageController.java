package ua.com.codegroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.service.UserService;

@Controller
public class indexPageController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestParam("username") String username,
                           @RequestParam("password") String password) {

        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        userService.save(user);
        return "index";

    }

}
