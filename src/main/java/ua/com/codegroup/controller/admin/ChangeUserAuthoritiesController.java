package ua.com.codegroup.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.codegroup.entity.Authority;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChangeUserAuthoritiesController {

    @Autowired
    UserService userService;

    @GetMapping("/admin/{user}-changeAuthorities")
    public String viewUserAuthorities(@PathVariable("user") String name, Model model) {

        User user = userService.findByName(name);
        model.addAttribute("user", user);
        model.addAttribute("id", user.getId());
        model.addAttribute("userAuthority", Authority.ROLE_USER);
        model.addAttribute("managerAuthority", Authority.ROLE_MANAGER);

        return "/admin/ChangeUserAuthorities";
    }

    @PostMapping("/admin/ChangeUserAuthorities")
    public String changeUserAuthorities(@RequestParam int userId,
                                        @RequestParam Authority authority) {


        userService.updateAuthority(userId, authority);
        return "redirect:/";

    }


}
