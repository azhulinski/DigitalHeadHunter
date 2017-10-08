package ua.com.codegroup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.codegroup.entity.UserTaskToDo;

import java.util.List;

public interface TaskDAO extends JpaRepository <UserTaskToDo, Integer> {

    @Query("select t from UserTaskToDo t join fetch t.user where t.user.id=:id")
    List<UserTaskToDo> findTaskByUserId(@Param("id") int id);

    @Query("select t from UserTaskToDo t where t.taskName=:name")
    UserTaskToDo findTaskByTaskName(@Param("name") String name);

}