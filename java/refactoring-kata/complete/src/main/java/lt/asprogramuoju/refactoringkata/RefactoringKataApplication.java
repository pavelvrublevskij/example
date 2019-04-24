package lt.asprogramuoju.refactoringkata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RefactoringKataApplication {

    public static void main(String[] args) {
        SpringApplication.run(RefactoringKataApplication.class, args);
    }

}
