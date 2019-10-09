package lt.asprogramuoju.jersey.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Simple Person domain class to understand how hibernate works
 *
 * @author Pavel Vrublevskij
 */
@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String firstname;
    private String lastname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstname +
                ", lastName=" + lastname + '}';
    }
}