package lt.asprogramuoju.example.camel.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@ApiModel(description = "Represents an task of the system")
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private Date dateDeadline;

    @Column(nullable = false, columnDefinition = "varchar default 'Low'")
    private String priority;

    @ManyToMany(mappedBy = "hasTask")
    private List<Person> persons;

}
