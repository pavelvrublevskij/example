package lt.asprogramuoju.example.camel.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private Date dateDeadline;

    @Column(nullable = false, columnDefinition = "varchar default 'Low'")
    private String priority;

//    @ManyToMany(mappedBy = "hasTask")
//    private List<Person> persons;

}
