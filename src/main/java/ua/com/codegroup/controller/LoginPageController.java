package ua.com.codegroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

    @GetMapping("/toLogin")
    public String toLogin() {
        return "/login";
    }
}
