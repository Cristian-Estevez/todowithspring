package estevezcristian.todowithspring.dao;

import estevezcristian.todowithspring.models.Task;
import java.util.List;

public interface TaskDao {

    List<Task> getTasks(Long id);

    void createTask(Task task, Long folderId);

    void updateTask(Task task);

    void markUnmarkTask(Task task);

    void deleteTask(Long id);

}
