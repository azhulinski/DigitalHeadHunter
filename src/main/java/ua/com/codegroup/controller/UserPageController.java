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
        UserDetailedInfo userDetailedInfo = userDetailedInfoService.findDetailsByUserId(user.getId());
        model.addAttribute("userName", principal.getName());
        model.addAttribute("userId", user.getId());


        if (userDetailedInfo != null) {
            model.addAttribute("detailedInfoId", userDetailedInfo.getId());
            model.addAttribute("firstName", userDetailedInfo.getFirstName());
            model.addAttribute("lastName", userDetailedInfo.getLastName());
            return "/user/editUserDetails";
        }

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
    public String editUserDetails(@RequestParam String firstName,
                                  @RequestParam String lastName,
                                  @RequestParam Date dateOfBirth,
                                  @RequestParam String gender,
                                  @RequestParam Boolean married,
                                  @Validated UserDetailedInfo userDetailedInfo,
                                  BindingResult bindingResult,
                                  Principal principal) {

        User user = userService.findByName(principal.getName());
        UserDetailedInfo detailedInfo = userDetailedInfoService.findDetailsByUserId(user.getId());

        if (detailedInfo != null) {
            int detailedInfoId = detailedInfo.getId();
            detailedInfo
                    .builder()
                    .id(detailedInfoId)
                    .firstName(firstName)
                    .lastName(lastName)
                    .dateOfBirth(dateOfBirth)
                    .gender(gender)
                    .married(Boolean.valueOf(married))
                    .build();
            userDetailedInfoService.save(userDetailedInfo);
            return "/user/tmp/success";
        }

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors().toString());
            return "/user/editUserDetails";
        }

        userDetailedInfoService.save(userDetailedInfo);
        System.out.println(userDetailedInfo.isMarried());
        return "/user/tmp/success";
    }

    @GetMapping("/user/{name}")
    public String viewUserDetails(@PathVariable("name") String name, Model model, Principal principal) {
        User user = userService.findByName(principal.getName());

        UserDetailedInfo userDetailedInfo = userDetailedInfoService.findDetailsByUserId(user.getId());
        if (userDetailedInfo != null) {
            model.addAttribute("user", user);

            Date date = userDetailedInfo.getDateOfBirth();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD-MM-YYYY");
            String outputDate = simpleDateFormat.format(date);

            model.addAttribute("firstName", userDetailedInfo.getFirstName());
            model.addAttribute("lastName", userDetailedInfo.getLastName());
            model.addAttribute("dateOfBirth", outputDate);
            model.addAttribute("gender", userDetailedInfo.getGender());
            model.addAttribute("married", userDetailedInfo.isMarried());

            return "user/viewUserDetails";
        } else {

            return "redirect:user/editUserDetails";
        }

    }

    /*@GetMapping("/user/updateInfo")
    public String updateInfo(Model model, Principal principal) {
        User user = userService.findByName(principal.getName());
        model.addAttribute("userName", user.getUsername());
        return "/user/updateInfo";
    }

    @PostMapping
    public String updateInfo(@RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam Date dateOfBirth,
                             @RequestParam String gender,
                             @RequestParam Boolean married,
                             Model model,
                             Principal principal) {
        User user = userService.findByName(principal.getName());
        UserDetailedInfo userDetailedInfo = userDetailedInfoService.findDetailsByUserId(user.getId());

        model.addAttribute("user", user);

        model.addAttribute("firstName", userDetailedInfo.getFirstName());
        model.addAttribute("lastName", userDetailedInfo.getLastName());
        System.out.println(userDetailedInfo.isMarried());

        System.out.println(married);

        userDetailedInfo
                .builder()
                .id(userDetailedInfo.getId())
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(dateOfBirth)
                .gender(gender)
                .married(Boolean.valueOf(married))
                .build();
        userDetailedInfoService.save(userDetailedInfo);
        return "/user/tmp/success";
    }*/

    @GetMapping("/user/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "/";
    }

}
