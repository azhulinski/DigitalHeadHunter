package ua.com.codegroup.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.service.UserDetailedInfoService;
import ua.com.codegroup.service.UserService;

@Controller
public class DeleteUserController {

    @Autowired
    UserService userService;

    @Autowired
    UserDetailedInfoService userDetailedInfoService;

    @PostMapping("/admin/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {

        userService.delete(id);


        return "redirect:/";
    }

}
