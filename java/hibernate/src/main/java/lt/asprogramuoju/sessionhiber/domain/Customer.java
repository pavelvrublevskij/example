package lt.asprogramuoju.sessionhiber.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Customer domain
 * <p>
 *     <b>This class shown PlantUML</b>
 * </p>
 *
 * @author pvrublevskij
 *
 * @plantuml.domainModuleName Customer Domain Module UML
 * @note This is note
 */
@Entity(name = "Customer")
@Table(name = "customer",
        uniqueConstraints = @UniqueConstraint(
                name = "customer_key",
                columnNames = {
                        "name",
                        "surname",
                        "birthDate"
                }
        ),
        indexes = @Index(
                name = "customer_customer_type_idx",
                columnList = "customer_type_id",
                unique = false
        ))
@Data
@EqualsAndHashCode(callSuper=false)
public class Customer extends SuperDomain {

    @NotNull
    @Column(length = 30)
    private String name;

    @NotNull
    @Column(length = 50)
    private String surname;

    /**
     * @plantuml.skip
     */
    @Column(nullable = false)
    private LocalDate birthDate;

    @Formula(value = "date_part('year', age(birthDate))")
    protected int age;

    @Column(nullable = false, length = 8)
    private String mobileNumber;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER) // By default, the JPA @ManyToOne and @OneToOne annotations are fetched EAGERly
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "customer_type_id",
            columnDefinition = "int default 1",
            foreignKey = @ForeignKey(name = "customer_customer_type_to_customer_type_id_fkey"))
    private CustomerType customerType;

    public Customer(String name, String surname, LocalDate birthDate, String mobileNumber, CustomerType customerType){

        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.mobileNumber = mobileNumber;
        this.customerType = customerType;
    }

    private void testMethod() {
        return;
    }
}
