package ua.com.codegroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.codegroup.entity.UserDetailedInfo;
import ua.com.codegroup.service.UserDetailedInfoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserPageController {

    @Autowired
    UserDetailedInfoService userDetailedInfoService;

    @GetMapping("/user/main")
    public String mainUserPage() {
        return "/user/main";
    }

    @GetMapping("/user/adduserdetails")
    public String addUserDetails(Model model) {
        return "/user/adduserdetails";
    }

    @InitBinder
    public void binder(WebDataBinder webDataBinder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");
        simpleDateFormat.setLenient(true);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
    }

    @PostMapping("/user/adduserdetails")
    public String addUserDetails(@Validated UserDetailedInfo userDetailedInfo, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/user/adduserdetails";
        }
        userDetailedInfoService.save(userDetailedInfo);
        return "/user/main";
    }

}
