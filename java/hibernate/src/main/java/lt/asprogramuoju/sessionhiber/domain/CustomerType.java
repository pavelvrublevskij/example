package lt.asprogramuoju.sessionhiber.domain;

import lombok.*;
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
public class CustomerType {

    @Id
    private Long id;

    @NonNull
    @Column(length = 10)
    private String name;

    public CustomerType(CustomerTypeEnum customerTypeName) {
        this.id = (long)customerTypeName.getId();
        this.name = customerTypeName.getName();
    }

    public CustomerType(){}
}
