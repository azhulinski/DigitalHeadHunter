package ua.com.codegroup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.codegroup.dao.TaskDAO;
import ua.com.codegroup.entity.UserTaskToDo;
import ua.com.codegroup.service.UserTaskToDoService;

import java.util.List;

public class UserTaskToDoServiceImpl implements UserTaskToDoService {

    @Autowired
    TaskDAO taskDAO;

    @Override
    public void save(UserTaskToDo userTaskToDo) {

    }

    @Override
    public List<UserTaskToDo> findAllTasks() {
        return taskDAO.findAll();
    }

    @Override
    public UserTaskToDo findOne(int id) {
        return taskDAO.findOne(id);
    }

    @Override
    public UserTaskToDo findTakByUserId(int id) {
        return taskDAO.findTaskByUserId(id);
    }
}
