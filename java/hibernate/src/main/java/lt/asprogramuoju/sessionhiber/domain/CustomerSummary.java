package lt.asprogramuoju.sessionhiber.domain;

import lombok.Data;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author pvrublevskij
 */
@Entity
@Subselect(
        "SELECT " +
                "	a.id as id, " +
                "	concat(concat(a.name, ' '), a.surname) AS customerName, " +
                "   b.name AS customerType" +
                "FROM customer a " +
                "   JOIN customer_type b on a.customer_id = b.id"
)
@Synchronize( {"customer", "customer_type"} )
@Data
public class CustomerSummary {

    @Id
    private Long id;

    private String customerName;
    private String customerType;
}
