package lt.asprogramuoju.impl;

import lt.asprogramuoju.bean.Group;
import lt.asprogramuoju.bean.Person;
import lt.asprogramuoju.bean.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class JavaStudentsGroup extends PersonGroupImpl<Group, List<Student>> {

    /**
     * Set only one Student object to group
     * @param group {@link Group}
     * @param student {@link Student}
     * @param doSort when true will sort by Name, then Surname, then Number
     */
    public void setToGroup(Group group, Student student, boolean doSort) {
        List<Student> students = get(group);
        if (students == null) {
            students = new ArrayList<>();
        }

        students.add(student);
        setToGroup(group, students, doSort);
    }

    @Override
    public Comparator<Person> setComparator() {
        return Comparator.comparing(Person::getName)
                .thenComparing(Person::getSurname)
                .thenComparingLong(Person::getNumber);
    }
}
