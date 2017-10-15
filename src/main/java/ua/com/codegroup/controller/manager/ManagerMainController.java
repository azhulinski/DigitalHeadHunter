package ua.com.codegroup.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.service.UserService;

import java.security.Principal;

@Controller
public class ManagerMainController {

    @Autowired
    UserService userService;

    @GetMapping("/depmanager/main")
    public String mainPage(Principal principal, Model model) {

        User user = userService.findByName(principal.getName());

        if (user.isPasswordDefault()) {
            model.addAttribute("userId", user.getId());
            return "/user/changePassword";

        } else {
            model.addAttribute("user", user.getUsername());
            model.addAttribute("userId", user.getId());
            return "/depmanager/main";
        }


    }
}
