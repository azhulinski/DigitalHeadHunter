package ua.com.codegroup.service.Editors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.codegroup.entity.User;
import ua.com.codegroup.service.UserService;

import java.beans.PropertyEditorSupport;

@Component
public class UserEditor extends PropertyEditorSupport {

    @Autowired
    private UserService userService;

    @Override
    public void setAsText(String userId) throws IllegalArgumentException {
        int id = Integer.parseInt(userId);
        User user = userService.findOne(id);
        setValue(user);
    }
}
