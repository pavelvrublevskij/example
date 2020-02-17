package lt.asprogramuoju.bean;

public class Student implements Person {

    private int id;
    private String name;
    private String surname;
    private Long number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Student(int id, String name, String surname, Long number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.number = number;
    }

    /**
     * Read more about compareTo https://mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
     */
    @Override
    public int compareTo(Person anotherPerson) {
        //descending order
        //int numberCompare = anotherStudent.number - this.number;

        //ascending order
        int numberCompare = this.number.compareTo(anotherPerson.getNumber());

        //ascending order
        int nameCompare = this.name.compareTo(anotherPerson.getName());

        //ascending order
        int surnameCompare = this.surname.compareTo(anotherPerson.getSurname());

        if (numberCompare != 0) return numberCompare;
        if (nameCompare != 0) return nameCompare;
        return surnameCompare;
    }

}
