package estevezcristian.todowithspring.dao;

import estevezcristian.todowithspring.models.Folder;
import estevezcristian.todowithspring.models.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Task> getTasks(Long id) {
        Folder folder = entityManager.find(Folder.class, id);
        List<Task> tasksById = entityManager.createQuery(
                        "SELECT t FROM Task t WHERE t.folder = :id", Task.class)
                .setParameter("id", folder)
                .getResultList();
        return tasksById;
    }

    @Override
    public void createTask(Task task, Long folderId) {
        task.setFolder(entityManager.find(Folder.class, folderId));
        entityManager.merge(task);
    }

    @Override
    public void updateTask(Task task) {
        Task tempTask = entityManager.find(Task.class, task.getId());
        tempTask.setTitle(task.getTitle());
    }

    @Override
    public void markUnmarkTask(Task task) {
        Task tempTask = entityManager.find(Task.class, task.getId());
        if (tempTask.getCompleted() == false){
            tempTask.setCompleted(true);
        } else if (tempTask.getCompleted() == true){
            tempTask.setCompleted(false);
        }
        tempTask.setTitle(task.getTitle());
    }

    @Override
    public void deleteTask(Long id) {
        Task taskToDelete = entityManager.find(Task.class, id);
        entityManager.remove(taskToDelete);
    }

}
