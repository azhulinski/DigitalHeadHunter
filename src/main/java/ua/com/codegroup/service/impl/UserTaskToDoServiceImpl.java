package ua.com.codegroup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codegroup.dao.TaskDAO;
import ua.com.codegroup.entity.UserTaskToDo;
import ua.com.codegroup.service.UserTaskToDoService;

import java.util.List;

@Service
@Transactional
public class UserTaskToDoServiceImpl implements UserTaskToDoService {

    @Autowired
    TaskDAO taskDAO;

    @Override
    public void save(UserTaskToDo userTaskToDo) {
        System.out.println(userTaskToDo.getTaskName());
        taskDAO.save(userTaskToDo);

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
    public List<UserTaskToDo> findTaskByUserId(int id) {
        return taskDAO.findTaskByUserId(id);
    }
}
