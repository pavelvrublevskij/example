package lt.asprogramuoju.example.camel.route;

import jdk.nashorn.internal.ir.annotations.Reference;
import lt.asprogramuoju.example.camel.domain.Task;
import lt.asprogramuoju.example.camel.service.TaskService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;

@Component
public class TaskRoute extends RouteBuilder {

    @Autowired
    private TaskService taskService;

    @Override
    public void configure() throws Exception {

        restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

        rest("/api").description("Tasks REST service")
                .get("/task").description("The list of all the tasks")
                .produces(MediaType.APPLICATION_JSON)
                .consumes(MediaType.APPLICATION_JSON)
                .route().routeId("tasks-api")
                .bean(taskService, "getAllTasks")
                .endRest()

                .post("/task").description("Create new task")
                .id("api-new-task")
                .consumes(MediaType.APPLICATION_JSON)
                .type(Task.class).outType(Task.class)
                .responseMessage().code(200).message("Task saved successfully").endResponseMessage()
                .route()
                .bean(taskService, "addTask")
                .endRest()

                .delete("/task/{id}").description("Remove persons tasks by task id if task does not have subtask")
                .id("delete-task-by-id")
                .responseMessage().code(200).message("Person task removed successfully").endResponseMessage()
                .responseMessage().code(201).message("Person has active tasks and could be not removed").endResponseMessage()
                .route()
                .bean(taskService, "deleteTask(${header.id})")
                .endRest();
    }
}
