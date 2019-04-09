package lt.asprogramuoju.example.camel.route;

import lt.asprogramuoju.example.camel.service.TaskService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;

@Component
public class TaskRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

        rest("/tasks").description("Tasks REST service")
                .get("/").description("The list of all the tasks")
                .produces(MediaType.APPLICATION_JSON)
                .consumes(MediaType.APPLICATION_JSON)
                .route().routeId("tasks-api")
                .bean(TaskService.class, "getAllTasks")
                .endRest();
    }
}
