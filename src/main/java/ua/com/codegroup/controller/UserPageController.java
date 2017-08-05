package ua.com.codegroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.entity.UserDetailedInfo;
import ua.com.codegroup.service.Editors.UserEditor;
import ua.com.codegroup.service.UserDetailedInfoService;
import ua.com.codegroup.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller

public class UserPageController {

    @Autowired
    UserDetailedInfoService userDetailedInfoService;

    @Autowired
    UserService userService;

    @Autowired
    UserEditor userEditor;

    @GetMapping("/user/main")
    public String mainUserPage(Model model, Principal principal) {
        model.addAttribute("user", userService.findByName(principal.getName()));
        return "/user/main";
    }

    @GetMapping("/user/editUserDetails")
    public String editUserDetails(Model model, Principal principal) {

        User user = userService.findByName(principal.getName());
        model.addAttribute("userName", principal.getName());
        model.addAttribute("id", user.getId());

        return "/user/editUserDetails";
    }

    @InitBinder
    public void binder(WebDataBinder webDataBinder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");
        simpleDateFormat.setLenient(true);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
        webDataBinder.registerCustomEditor(User.class, userEditor);

    }

    @PostMapping("/user/editUserDetails")
    public String editUserDetails(@Validated UserDetailedInfo userDetailedInfo,
                                  BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return "/user/editUserDetails";
        }

        userDetailedInfoService.save(userDetailedInfo);
        return "/user/tmp/success";
    }
    @GetMapping("/user/{name}")
    public String viewUserDetails(@PathVariable("name") String name, Model model, Principal principal) {

        model.addAttribute("name", principal.getName());


        return "user/viewUserDetails";
    }

    @GetMapping("/user/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "/";
    }

}
