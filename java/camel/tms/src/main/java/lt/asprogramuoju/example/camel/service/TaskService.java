package lt.asprogramuoju.example.camel.service;

import lt.asprogramuoju.example.camel.domain.Task;
import lt.asprogramuoju.example.camel.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    private static List<Task> TASK;

    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void addTask(Task task) {
        if (null == task) {
            throw new IllegalArgumentException("Task must not be null");
        }

        TASK.add(task);
    }

    public void deleteTask(Long id) {
        if (null == id) {
            throw new IllegalArgumentException("name must not be null");
        }


        TASK.removeIf(Task -> Task.getId().intValue() == id);
    }
}
