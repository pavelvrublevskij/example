package lt.asprogramuoju.example.camel.service;

import lt.asprogramuoju.example.camel.domain.Task;
import lt.asprogramuoju.example.camel.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
