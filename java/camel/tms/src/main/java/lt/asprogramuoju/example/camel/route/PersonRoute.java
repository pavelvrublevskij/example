package lt.asprogramuoju.example.camel.route;

import lt.asprogramuoju.example.camel.service.PersonService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

//import javax.ws.rs.core.MediaType;

@Component
public class PersonRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

        rest("/persons").description("Persons REST service")
                .get("/").description("The list of all the persons")
//                .produces(MediaType.APPLICATION_JSON)
//                .consumes(MediaType.APPLICATION_JSON)
                .route().routeId("persons-api")
                .bean(PersonService.class, "getAllPersons")
                .endRest();
    }
}
