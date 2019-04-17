package lt.asprogramuoju.example.camel.service;

import ch.qos.logback.core.db.dialect.SQLDialect;
import lt.asprogramuoju.example.camel.domain.Person;
import lt.asprogramuoju.example.camel.repository.PersonRepository;
//import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service("personService")
public class PersonService {

    private final Map<Integer, Person> persons = new TreeMap<>();

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonRepository personRepository;

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @PersistenceContext
//    private SessionFactory sessionFactory;

    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person findUser(Integer id) {
        return persons.get(id);
    }

//    private void getPersons(){
//        Query q = entityManager.createQuery("SELECT name FROM CustomerType");
//        List<Object[]> list = q.getResultList();
//
//        for (Object value: list) {
//            System.out.println("CustomerType " + value);
//        }
//    }

    public void makeAdditionalHibernateDefaultAction() {
        logger.info("All persons-> {}", personRepository.findAll());

        //Insert
        Person person1 = new Person("John", "Snow");
        logger.info("Inserting -> {}", personRepository.save(person1));

        //Update inserted
        logger.info("Update last -> {}", personRepository.save(new Person(person1.getId(), "Firstname", "Lastname")));

        personRepository.deleteById(3L);
        logger.info("All persons -> {}", personRepository.findAll());
    }

}
