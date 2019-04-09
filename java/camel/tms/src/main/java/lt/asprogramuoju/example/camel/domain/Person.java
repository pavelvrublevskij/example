package lt.asprogramuoju.example.camel.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

//    @ManyToMany
//    private List<Task> hasTask;

}