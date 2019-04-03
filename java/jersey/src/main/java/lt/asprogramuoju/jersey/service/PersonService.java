package lt.asprogramuoju.jersey.service;

import lt.asprogramuoju.jersey.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private JdbcTemplate jtm;

    public List<Person> findAll() {
        String sql = "SELECT * FROM PERSON";
        List<Person> persons = jtm.query(sql, new BeanPropertyRowMapper(Person.class));
        return persons;
    }
}
