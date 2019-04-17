package lt.asprogramuoju.example.camel.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
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
    @Lob
    private String description;

    private Date dateDeadline;

    private Integer timeSpent;

    private Boolean isFinished;

    @Column(nullable = false, columnDefinition = "varchar default 'Low'")
    private String priority;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "personHasTask"
    )
    @JsonIgnore
    private Set<Person> persons;


    @NotNull
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "task_group_id",
            columnDefinition = "int default 1",
            foreignKey = @ForeignKey(name = "task_task_group_id_to_task_group_id_fkey"))
    private TaskGroup taskGroup;

    @ManyToOne
    @JoinColumn(name = "parent_task_id",
            foreignKey = @ForeignKey(name = "task_parent_task_id_to_task_id_fkey"))
    private Task parentTask;
}
