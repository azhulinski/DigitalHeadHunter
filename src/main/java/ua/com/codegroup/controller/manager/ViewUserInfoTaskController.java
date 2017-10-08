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
        int id = user.getId();

        UserDetailedInfo userDetailedInfo = userDetailedInfoService.findDetailsByUserId(id);

        List<UserTaskToDo> userTaskToDo = userTaskToDoService.findTaskByUserId(id);

        model.addAttribute("user", user);

        if (userDetailedInfo != null) {
            Date date = userDetailedInfo.getDateOfBirth();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String outputDate = simpleDateFormat.format(date);
            model.addAttribute("dateOfBirth", outputDate);


        model.addAttribute("firstName", userDetailedInfo.getFirstName());
        model.addAttribute("lastName", userDetailedInfo.getLastName());
        }

        return "/depmanager/viewuserinfo";
    }


}
