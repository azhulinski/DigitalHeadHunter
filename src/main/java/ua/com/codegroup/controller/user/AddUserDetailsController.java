package ua.com.codegroup.controller.user;

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
import org.springframework.web.multipart.MultipartFile;
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
public class AddUserDetailsController {

    @Autowired
    UserDetailedInfoService userDetailedInfoService;

    @Autowired
    UserService userService;

    @Autowired
    UserEditor userEditor;

    @GetMapping("/user/addUserDetails")
    public String addUserDetails(Model model, Principal principal) {

        User user = userService.findByName(principal.getName());

        UserDetailedInfo userDetailedInfo = userDetailedInfoService.findDetailsByUserId(user.getId());

        if (userDetailedInfo == null) {
            model.addAttribute("addUserInfo", new UserDetailedInfo());
            model.addAttribute("userName", principal.getName());
            model.addAttribute("userId", user.getId());

            return "/user/addUserDetails";

        } else {
            return "redirect:/user/updateUserDetails";
        }

    }

    @InitBinder
    public void binder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

        webDataBinder.registerCustomEditor(User.class, userEditor);

    }

    @PostMapping("/user/addUserDetails")
    public String addUserDetails(@ModelAttribute("addUserInfo") @Validated UserDetailedInfo userDetailedInfo,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors().toString());
            return "/user/addUserDetails";
        }
        userDetailedInfoService.save(userDetailedInfo);

        return "/user/tmp/success";
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
