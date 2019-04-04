package lt.asprogramuoju.jersey.controller;

import lt.asprogramuoju.jersey.domain.Person;
import lt.asprogramuoju.jersey.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/persons")
    public List<Person> findAll() {
        return personService.findAll();
    }
}
