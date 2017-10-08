package ua.com.codegroup.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
                                     @RequestParam String password,
                                     HttpServletRequest request,
                                     HttpServletResponse response,
                                     Authentication authentication) {

        User user = userService.findOne(id);

        user.setPassword(password);
        user.setPasswordDefault(false);

        userService.save(user);

        //logout after password has been changed

        authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            HttpSession session = request.getSession();

            session.invalidate();

        }

        return "redirect:/login";
    }

}
