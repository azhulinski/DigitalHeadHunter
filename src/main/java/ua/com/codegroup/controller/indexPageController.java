package ua.com.codegroup.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.codegroup.service.UserService;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class indexPageController {

    @Autowired
    UserDetailsService userService;

    @GetMapping("/")
    public String index(Locale locale, Model model) {

        System.out.println(userService.loadUserByUsername("qqq"));
        locale = new Locale("en", "US");
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        return "index";
    }


}
