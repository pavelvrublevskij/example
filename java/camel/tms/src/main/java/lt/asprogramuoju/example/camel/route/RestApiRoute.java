package lt.asprogramuoju.example.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RestApiRoute extends RouteBuilder {

    @Value("${server.port}")
    String serverPort;

    @Override
    public void configure() {

        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json)

                .enableCORS(true)

                //Enable swagger endpoint.
                .apiContextPath("/api-doc") //swagger endpoint path
                .apiContextRouteId("api-doc") //id of route providing the swagger endpoint

                //Swagger properties
                .contextPath("/api")
                .port(serverPort)
                .apiProperty("base.path", "/api")
                .apiProperty("api.title", "Task Management System (Example) REST API")
                .apiProperty("api.version", "v1")
                .apiProperty("cors", "true") // cross-site
                .apiContextRouteId("doc-api")
                .dataFormatProperty("prettyPrint", "true");
    }
}
