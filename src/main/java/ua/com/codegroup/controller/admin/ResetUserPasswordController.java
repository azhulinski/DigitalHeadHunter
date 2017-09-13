package ua.com.codegroup.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.service.UserService;

@Controller
public class ResetUserPasswordController {

    @Autowired
    UserService userService;

    @PostMapping("/admin/resetPassword")
    public String resetUserPassword(@RequestParam int userId) {

        User user = userService.findOne(userId);

        String newPassword = "11111";

        user.setPassword(newPassword);

        user.setPasswordDefault(true);

        userService.save(user);

        return "redirect:/";
    }

}
