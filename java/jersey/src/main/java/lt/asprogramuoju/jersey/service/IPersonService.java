package lt.asprogramuoju.jersey.service;

import lt.asprogramuoju.jersey.bean.Person;

import java.util.List;

public interface IPersonService {
    public List<Person> findAll();
}
