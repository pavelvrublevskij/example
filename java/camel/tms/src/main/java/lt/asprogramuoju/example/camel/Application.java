package lt.asprogramuoju.example.camel;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.component.swagger.DefaultCamelSwaggerServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
//@ComponentScan(basePackages = {"lt.asprogramuoju.example.camel.*"})
public class Application extends SpringBootServletInitializer {

    @Autowired
    private Environment env;

    private static final String CAMEL_URL_MAPPING = "/api/*";
    private static final String CAMEL_SERVLET_NAME = "CamelServlet";

//    @Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(Application.class);
//    }

	public static void main(String[] args) {
	    SpringApplication.run(Application.class, args);
	}

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registration =
                new ServletRegistrationBean(new CamelHttpTransportServlet(), CAMEL_URL_MAPPING);
        registration.setName(CAMEL_SERVLET_NAME);
        return registration;
    }

    @Bean
    public ServletRegistrationBean swaggerServlet() {
        ServletRegistrationBean swagger = new ServletRegistrationBean(new DefaultCamelSwaggerServlet(), "/api-doc/*");
        Map<String, String> params = new HashMap<>();
        params.put("base.path", "api");
        params.put("api.title", "Task Management System");
        params.put("api.description", "This is example of TMS");
        params.put("api.termsOfServiceUrl", "termsOfServiceUrl");
        params.put("api.license", "license");
        params.put("api.licenseUrl", "licenseUrl");
        swagger.setInitParameters(params);
        return swagger;
    }

//    @Component
//    class RestApi extends RouteBuilder {
//
//        @Override
//        public void configure() {
//            restConfiguration()
//                    .contextPath("/camel-rest-jpa").apiContextPath("/api-doc")
//                    .apiProperty("api.title", "Camel REST API")
//                    .apiProperty("api.version", "1.0")
//                    .apiProperty("cors", "true")
//                    .apiContextRouteId("doc-api")
//                    .port(env.getProperty("server.port", "8080"))
//                    .bindingMode(RestBindingMode.json);

//            rest("/books").description("Books REST service")
//                    .get("/").description("The list of all the books")
//                    .route().routeId("books-api")
//                    .bean(Database.class, "findBooks")
//                    .endRest()
//                    .get("order/{id}").description("Details of an order by id")
//                    .route().routeId("order-api")
//                    .bean(Database.class, "findOrder(${header.id})");
//        }
//    }

//    @Component
//    class Backend extends RouteBuilder {
//
//        @Override
//        public void configure() {
//            // A first route generates some orders and queue them in DB
//            from("timer:new-order?delay=1s&period={{example.generateOrderPeriod:2s}}")
//                    .routeId("generate-order")
//                    .bean("orderService", "generateOrder")
//                    .to("jpa:lt.asprogramuoju.example.camel.Order")
//                    .log("Inserted new order ${body.id}");
//
//            // A second route polls the DB for new orders and processes them
//            from("jpa:lt.asprogramuoju.example.camel.Order"
//                    + "?consumer.namedQuery=new-orders"
//                    + "&consumer.delay={{example.processOrderPeriod:5s}}"
//                    + "&consumeDelete=false")
//                    .routeId("process-order")
//                    .log("Processed order #id ${body.id} with ${body.amount} copies of the «${body.book.description}» book");
//        }
//    }
}
