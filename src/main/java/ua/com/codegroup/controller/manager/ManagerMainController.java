package ua.com.codegroup.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerMainController {

    @GetMapping("/depmanager/main")
    public String mainPage() {

        return "/depmanager/main";

    }
}
