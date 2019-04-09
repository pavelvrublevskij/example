package lt.asprogramuoju.example.camel.service;

import lt.asprogramuoju.example.camel.domain.Person;
import lt.asprogramuoju.example.camel.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service("personService")
public class PersonService {

    private final Map<Integer, Person> persons = new TreeMap<>();

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person findUser(Integer id) {
        return persons.get(id);
    }

}
