package ua.com.codegroup.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.entity.UserDetailedInfo;
import ua.com.codegroup.service.UserDetailedInfoService;
import ua.com.codegroup.service.UserService;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ViewUserInfoController {

    @Autowired
    UserService userService;

    @Autowired
    UserDetailedInfoService userDetailedInfoService;

    @GetMapping("/admin/{name}-info")
    public String viewUserDetails(@PathVariable("name") String name, Model model) {
        User user = userService.findByName(name);
        model.addAttribute("user", user);

        UserDetailedInfo userDetailedInfo = userDetailedInfoService.findDetailsByUserId(user.getId());

        if (userDetailedInfo == null) {

            model.addAttribute("authorities", user.getAuthority());

            model.addAttribute("userId", user.getId());
            return "admin/viewUserInfo";
        } else {

            Date date = userDetailedInfo.getDateOfBirth();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String outputDate = simpleDateFormat.format(date);

            model.addAttribute("authorities", user.getAuthority());
            model.addAttribute("firstName", userDetailedInfo.getFirstName());
            model.addAttribute("lastName", userDetailedInfo.getLastName());
            model.addAttribute("dateOfBirth", outputDate);
            model.addAttribute("gender", userDetailedInfo.getGender());
            model.addAttribute("married", userDetailedInfo.isMarried());
            model.addAttribute("userId", user.getId());
            model.addAttribute("avatar", user.getAvatar());

            return "admin/viewUserInfo";
        }

    }

}
