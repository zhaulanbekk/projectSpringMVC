package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Task;
import peaksoft.repository.TaskDao;
import peaksoft.service.TaskService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskDao taskDao;

    @Autowired
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public List<Task> getAllTasks(Long id) {
        return taskDao.getAllTasks(id);
    }

    @Override
    public void updateTask(Long id, Task task) {
        taskDao.updateTask(id, task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskDao.getTaskById(id);
    }

    @Override
    public Task addTask(Long lessonId, Task task) {
        return taskDao.addTask(lessonId, task);
    }

    @Override
    public void deleteTask(Long id) {
        taskDao.deleteTask(id);
    }
}
