package ua.com.codegroup.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.entity.UserDetailedInfo;
import ua.com.codegroup.entity.UserTaskToDo;
import ua.com.codegroup.service.UserDetailedInfoService;
import ua.com.codegroup.service.UserService;
import ua.com.codegroup.service.UserTaskToDoService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ViewUserInfoTaskController {

    @Autowired
    UserService userService;

    @Autowired
    UserDetailedInfoService userDetailedInfoService;

    @Autowired
    UserTaskToDoService userTaskToDoService;

    @GetMapping("/depmanager/{name}-info")
    public String viewUserInfo(@PathVariable("name") String name, Model model) {

        User user = userService.findByName(name);

        UserDetailedInfo userDetailedInfo = userDetailedInfoService.findDetailsByUserId(user.getId());

        List<UserTaskToDo> userTaskToDo = userTaskToDoService.findTaskByUserId(user.getId());

        for(UserTaskToDo u : userTaskToDo) {
            System.out.println(u);
        }

        model.addAttribute("user", user);

        Date date = userDetailedInfo.getDateOfBirth();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String outputDate = simpleDateFormat.format(date);

        model.addAttribute("firstName", userDetailedInfo.getFirstName());
        model.addAttribute("lastName", userDetailedInfo.getLastName());
        model.addAttribute("dateOfBirth", outputDate);

        return "/depmanager/viewuserinfo";
    }


}
