package ua.com.codegroup.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.service.UserService;

import java.security.Principal;

@Controller
public class UserMainController {

    @Autowired
    UserService userService;

    @GetMapping("/user/main")
    public String mainUserPage(Model model, Principal principal) {

        User user = userService.findByName(principal.getName());

        if (user.isPasswordDefault()) {
            return "/user/changePassword";

        } else {
            model.addAttribute("user", user.getUsername());
            model.addAttribute("userId", user.getId());
            return "/user/main";
        }
    }
}