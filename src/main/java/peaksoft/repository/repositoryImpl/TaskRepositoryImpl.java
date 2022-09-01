package peaksoft.repository.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Course;
import peaksoft.model.Lesson;
import peaksoft.model.Task;
import peaksoft.repository.TaskDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TaskRepositoryImpl implements TaskDao {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public List<Task> getAllTasks(Long id) {
        return manager.createQuery("SELECT t FROM Task t where t.lesson.id=:id", Task.class).setParameter("id", id).getResultList();
    }

    @Override
    public void updateTask(Long id, Task task) {
    Task task1 = getTaskById(id);
    task1.setTaskName(task.getTaskName());
    task1.setTaskText(task.getTaskText());
    manager.merge(task1);
    }

    @Override
    public Task getTaskById(Long id) {
        return manager.find(Task.class,id);
    }

    @Override
    public Task addTask(Long lessonId, Task task) {
        Lesson lesson = manager.find(Lesson.class, lessonId);
        lesson.addTask(task);
        task.setLesson(lesson);
        return manager.merge(task);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = manager.find(Task.class, id);
        task.setLesson(null);
        manager.remove(task);
    }
}
