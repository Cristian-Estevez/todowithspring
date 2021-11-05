package estevezcristian.todowithspring.controller;

import estevezcristian.todowithspring.dao.TaskDao;
import estevezcristian.todowithspring.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.SqlResultSetMapping;
import javax.persistence.StoredProcedureParameter;
import java.util.List;

@CrossOrigin
@RestController
public class TaskController {

    @Autowired
    private TaskDao taskDao;

    @CrossOrigin
    @RequestMapping(value = "/api/folder/{id}/task-list/")
    public List<Task> getTasks(@PathVariable Long id) {
        return taskDao.getTasks(id);
    }


    @RequestMapping(value = "/api/folder/{folderId}/task-update/{taskId}/", method = RequestMethod.POST, consumes="application/json")
    public void updateTask(@RequestBody Task task){
        taskDao.updateTask(task);
    }

    @RequestMapping(value = "/api/folder/{folderId}/task-delete/{taskId}/", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable Long folderId, @PathVariable Long taskId){
        taskDao.deleteTask(taskId);
    }

    @RequestMapping(value = "/api/folder/{folderId}/task-create/", method = RequestMethod.POST, consumes="application/json")
    public void createTask(@PathVariable Long folderId, @RequestBody Task task ){
        taskDao.createTask(task, folderId);
    }

}
