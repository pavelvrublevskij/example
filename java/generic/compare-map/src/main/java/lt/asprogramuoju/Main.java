package lt.asprogramuoju;

import lt.asprogramuoju.bean.Group;
import lt.asprogramuoju.bean.Person;
import lt.asprogramuoju.bean.Student;
import lt.asprogramuoju.impl.JavaStudentsGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final String DASHES = "----------------------------------------";
    private static final String GROUP_CAPPUCCINO = "Cappuccino";
    private static final String GROUP_LATTE = "LATTE";
    private static final String GROUP_TEA = "Tea";

    public static void main(String[] args) {

        Group cappuccinoGroup = new Group(GROUP_CAPPUCCINO);
        Group latteGroup = new Group(GROUP_LATTE);
        Group teaGroup = new Group(GROUP_TEA);

        JavaStudentsGroup studentGroup = new JavaStudentsGroup();
        List<Student> students1 = new ArrayList<>();
        List<Student> students2 = new ArrayList<>();
        students1.add(new Student(1, "Vardas", "Pavardenis", 56L));
        students1.add(new Student(2, "Vardas5", "Pavardenis5", 1L));
        students1.add(new Student(3, "Vardas3", "Pavardenis3", 34L));

        students2.add(new Student(1, "Petras", "Petraitis", 34L));
        students2.add(new Student(2, "Alma", "Almanė", 1L));
        students2.add(new Student(3, "Vardas3", "Pavardenis2", 24L));

        studentGroup.setToGroup(
                latteGroup, new Student(2, "Vardas3", "Pavardenis4", 2L), true);
        studentGroup.setToGroup(
                latteGroup , new Student(1, "Jonas", "Jonatis", 34L), true);

        studentGroup.fillData(cappuccinoGroup, students1);  // do not sort this group
        studentGroup.fillDataAndSort(teaGroup, students2);  // sort this group using PersonGroup lambda expression

        List<Student> cappuccinoGroupList = studentGroup.getByGroup(cappuccinoGroup);
        List<Student> latteGroupList = studentGroup.getByGroup(latteGroup);
        List<Student> teaGroupList = studentGroup.getByGroup(teaGroup);
        printStudents(GROUP_CAPPUCCINO, cappuccinoGroupList);
        printStudents(GROUP_LATTE, latteGroupList);
        printStudents(GROUP_TEA, teaGroupList);

        // show all students data
        List<Student> students = studentGroup.getAllData();
        // sort this data using Student compareTo override method
        Collections.sort(students);
        printStudents("All groups", students);
    }

    private static void printStudents(String groupName, List<Student> students) {
        System.out.println("\n" + groupName);
        System.out.println(DASHES);
        for (Person student: students) {
            System.out.printf("- %d %s %s %d\n" +
                    "", student.getId(), student.getName(), student.getSurname(), student.getNumber());
        }
        System.out.println(DASHES);
    }

}
