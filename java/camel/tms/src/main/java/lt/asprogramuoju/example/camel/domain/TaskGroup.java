package lt.asprogramuoju.example.camel.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=false)
public class TaskGroup extends SuperDomain {

    @NonNull
    @Column(length = 50)
    private String name;

}
