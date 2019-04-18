package lt.asprogramuoju.sessionhiber;

import lt.asprogramuoju.sessionhiber.service.DemoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SessionHiberApplication {

    public static void main(String[] args) {
        SpringApplication.run(SessionHiberApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(DemoService demoService) {
        return (args) -> demoService.init();
    }

}
