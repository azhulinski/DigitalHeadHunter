package ua.com.codegroup.controller.user;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.entity.UserDetailedInfo;
import ua.com.codegroup.service.Editors.UserEditor;
import ua.com.codegroup.service.UserDetailedInfoService;
import ua.com.codegroup.service.UserService;

import java.security.Principal;
import java.text.ParseException;
import java.util.Date;

@Controller
public class UpdateUserDetailsController {

    @Autowired
    UserService userService;

    @Autowired
    UserDetailedInfoService userDetailedInfoService;

    @Autowired
    UserEditor userEditor;

    @GetMapping("/user/updateUserDetails")
    public String updateUserDetails(Model model, Principal principal) {

        User user = userService.findByName(principal.getName());
        UserDetailedInfo userDetailedInfo = userDetailedInfoService.findDetailsByUserId(user.getId());

        model.addAttribute("userName", principal.getName());
        model.addAttribute("userId", user.getId());

        if (userDetailedInfo != null) {
            model.addAttribute("userDetailedInfo", userDetailedInfo);
            model.addAttribute("detailedInfoId", userDetailedInfo.getId());
            model.addAttribute("firstName", userDetailedInfo.getFirstName());
            model.addAttribute("lastName", userDetailedInfo.getLastName());
            model.addAttribute("dateOfBirth", userDetailedInfo.getDateOfBirth());
            return "/user/updateUserDetails";

        } else {
            return "redirect:/addUserDetails";
        }

    }


    @PostMapping("/user/updateUserDetails")
    public String updateUserDetails(Principal principal,
                                    @RequestParam int detailedInfoId,
                                    @RequestParam String firstName,
                                    @RequestParam String lastName,
                                    @RequestParam String dateOfBirth,
                                    @RequestParam String gender,
                                    @RequestParam Boolean married) throws ParseException {

        LocalDate localDate = LocalDate.parse(dateOfBirth);

        Date birthDate = localDate.toDate();

        User user = userService.findByName(principal.getName());

        UserDetailedInfo userDetailedInfo = UserDetailedInfo
                .builder()
                .id(detailedInfoId)
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(birthDate)
                .gender(gender)
                .married(married)
                .user(user)
                .build();
        userDetailedInfoService.save(userDetailedInfo);
        return "/user/tmp/success";
    }
}
