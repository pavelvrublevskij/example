package lt.asprogramuoju.example.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RestApiRoute extends RouteBuilder {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${tms.api.path}")
    String contextPath;


    @Value("${server.port}")
    String serverPort;

    @Bean
    ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servlet = new ServletRegistrationBean
                (new CamelHttpTransportServlet(), contextPath+"/*");
        servlet.setName("CamelServlet");
        return servlet;
    }

    @Override
    public void configure() {

        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json)

                .port(serverPort)
                .enableCORS(true)

                //Enable swagger endpoint.
                .apiContextPath("/api-doc") //swagger endpoint path
                .apiContextRouteId("api-doc") //id of route providing the swagger endpoint

                //Swagger properties
                .contextPath(contextPath) //base.path swagger property; use the mapping path set for CamelServlet
                .apiProperty("api.title", "Task Management System (Example) REST API")
                .apiProperty("api.version", "v1")
                .apiProperty("cors", "true") // cross-site
                .apiContextRouteId("doc-api")
                .dataFormatProperty("prettyPrint", "true");
    }
}
