package ua.com.codegroup.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codegroup.entity.UserTaskToDo;

import java.util.List;

@Service
@Transactional
public interface UserTaskToDoService {

    void save(UserTaskToDo userTaskToDo);

    UserTaskToDo oneTask(String name);

    List<UserTaskToDo> findAllTasks();

    UserTaskToDo findOne(int id);

    List<UserTaskToDo> findTaskByUserId(int id);

}
