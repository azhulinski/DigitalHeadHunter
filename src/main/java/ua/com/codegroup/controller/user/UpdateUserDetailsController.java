package ua.com.codegroup.controller.user;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.entity.UserDetailedInfo;
import ua.com.codegroup.service.Editors.UserEditor;
import ua.com.codegroup.service.UserDetailedInfoService;
import ua.com.codegroup.service.UserService;

import java.io.File;
import java.io.IOException;
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
            model.addAttribute("avatar", user.getAvatar());
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
                                    @RequestParam Boolean married,
                                    @RequestParam MultipartFile avatar) throws ParseException, IOException {

        String path = System.getProperty("user.home") + File.separator + "images" + File.separator;
        avatar.transferTo(new File(path + avatar.getOriginalFilename()));

        LocalDate localDate = LocalDate.parse(dateOfBirth);

        Date birthDate = localDate.toDate();
        if(birthDate == null) {
            birthDate = userDetailedInfoService
                    .findDetailsByUserId((userService.findByName(principal.getName())).getId()).getDateOfBirth();
        }

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
        userService.updateAvatar(user.getId(), "/img/" + avatar.getOriginalFilename());
        userDetailedInfoService.save(userDetailedInfo);
        return "/user/tmp/success";
    }
}
