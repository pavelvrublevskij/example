package lt.asprogramuoju.bean;

public interface Person extends Comparable<Person> {

    /**
     * Person identification
     * @return uniq id
     */
    int getId();

    /**
     * Person first name
     * @return first name
     */
    String getName();

    /**
     * Person last name
     * @return last name
     */
    String getSurname();

    /**
     * Person some number. Could be any, i.e. phone number, id card number, queue number and etc
     * @return number
     */
    Long getNumber();

}
