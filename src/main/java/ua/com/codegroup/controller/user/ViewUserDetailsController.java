package ua.com.codegroup.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.entity.UserDetailedInfo;
import ua.com.codegroup.service.UserDetailedInfoService;
import ua.com.codegroup.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ViewUserDetailsController {

    @Autowired
    UserService userService;

    @Autowired
    UserDetailedInfoService userDetailedInfoService;

    @GetMapping("/user/{name}-info")
    public String viewUserDetails(@PathVariable("name") String name, Model model) {
        User user = userService.findByName(name);

        UserDetailedInfo userDetailedInfo = userDetailedInfoService.findDetailsByUserId(user.getId());

        if (userDetailedInfo != null) {
            model.addAttribute("user", user);

            Date date = userDetailedInfo.getDateOfBirth();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String outputDate = simpleDateFormat.format(date);

            model.addAttribute("firstName", userDetailedInfo.getFirstName());
            model.addAttribute("lastName", userDetailedInfo.getLastName());
            model.addAttribute("dateOfBirth", outputDate);
            model.addAttribute("gender", userDetailedInfo.getGender());
            model.addAttribute("married", userDetailedInfo.isMarried());

            return "user/viewUserDetails";
        } else {

            return "redirect:/user/addUserDetails";
        }

    }

}
