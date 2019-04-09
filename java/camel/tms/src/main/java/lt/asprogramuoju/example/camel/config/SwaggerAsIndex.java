package lt.asprogramuoju.example.camel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
public class SwaggerAsIndex {

    @Value("${tms.api.path}")
    String contextPath;

    @Controller
    class SwaggerWelcome {
        @RequestMapping("/")
        public String redirectToUi() {
            return "redirect:/webjars/swagger-ui/index.html?url=" + contextPath + "/api-doc&validatorUrl=";
        }
    }
}
