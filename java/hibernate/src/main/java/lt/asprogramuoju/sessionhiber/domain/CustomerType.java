package lt.asprogramuoju.sessionhiber.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lt.asprogramuoju.sessionhiber.domain.enums.CustomerTypeEnum;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable  // ignore for all write operations
@Table(
        name = "customer_type",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"name"},
                        name="customer_type_key"
                )
        }
)
@Data
@NoArgsConstructor
public class CustomerType {

    @Id
    private Long id;

    @NonNull
    @Column(length = 10)
    private String name;

    public CustomerType(CustomerTypeEnum customerTypeName) {
        super();
        this.id = (long)customerTypeName.getId();
        this.name = customerTypeName.getName();
    }
}
