package lt.asprogramuoju.example.camel.service;

import lt.asprogramuoju.example.camel.domain.Person;
import lt.asprogramuoju.example.camel.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }


}
