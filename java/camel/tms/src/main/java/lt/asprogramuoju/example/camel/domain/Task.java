package lt.asprogramuoju.example.camel.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=false)
public class Task extends SuperDomain {

    @NonNull
    private String title;

    @NonNull
    private String description;

    private Date dateDeadline;

    @Column(nullable = false, columnDefinition = "varchar default 'Low'")
    private String priority;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "personHasTask")
    @JsonIgnore
    private Set<Person> persons;

}
