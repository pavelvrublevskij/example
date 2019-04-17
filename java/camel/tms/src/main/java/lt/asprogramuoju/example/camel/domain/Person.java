package lt.asprogramuoju.example.camel.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Person extends SuperDomain {

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "person_has_task",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    @JsonIgnore
    private Set<Task> personHasTask;

    public Person(Long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void removeTask(Task task) {
        personHasTask.remove(task);
        task.getPersons().remove(this);
    }

    @Override
    public String toString(){
        return "Person -> id = " + getId() +
                ", firstName = " + getFirstName() +
                ", lastName = " + getLastName();
    }
}