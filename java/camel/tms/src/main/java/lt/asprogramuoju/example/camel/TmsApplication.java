package lt.asprogramuoju.example.camel;

import lt.asprogramuoju.example.camel.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="lt.asprogramuoju.example.camel.*")
public class TmsApplication {

	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(TmsApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		logger.info("Person id 10001 -> {}", personRepository.findById(10001L));
//		logger.info("All person 1 -> {}", personRepository.findAll());
//
//		//Insert
//		logger.info("Inserting -> {}", personRepository.save(new Person("John", "Snow")));
//
//		//Update
//		logger.info("Update 10001 -> {}", personRepository.save(new Person(10001L, "Firstname", "Lastname")));
////		personRepository.deleteById(-2L);
//		logger.info("All persons 2 -> {}", personRepository.findAll());
//	}
}
