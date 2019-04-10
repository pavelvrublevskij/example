package lt.asprogramuoju.jersey.controller;

import lt.asprogramuoju.jersey.domain.Person;
import lt.asprogramuoju.jersey.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GET
    @RequestMapping("/persons")
    @Produces("application/json")
    public List<Person> findAll() {
        return personService.findAll();
    }
}
