package ua.com.codegroup.service;

import org.springframework.stereotype.Service;
import ua.com.codegroup.entity.UserTaskToDo;

import java.util.List;

@Service
public interface UserTaskToDoService {

    void save(UserTaskToDo userTaskToDo);

    List<UserTaskToDo> findAllTasks();

    UserTaskToDo findOne(int id);

    UserTaskToDo findTakByUserId(int id);

}
