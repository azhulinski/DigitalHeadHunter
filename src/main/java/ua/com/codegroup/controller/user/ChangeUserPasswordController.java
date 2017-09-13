package ua.com.codegroup.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.service.UserService;

import java.security.Principal;

@Controller
public class ChangeUserPasswordController {

    @Autowired
    UserService userService;

    @GetMapping("/user/changePassword/")
    public String changeUserPassword(Principal principal, Model model) {

        User user = userService.findByName(principal.getName());
        model.addAttribute("id", user.getId());
        return "/user/changePassword/";
    }

    @PostMapping("/user/changePassword/")
    public String changeUserPassword(@RequestParam int id,
                                     @RequestParam String password) {

        User user = userService.findOne(id);

        user.setPassword(password);

        System.out.println(id);
        System.out.println(user.getUsername());
        System.out.println(password);
        userService.save(user);


        return "user/main";
    }

}
