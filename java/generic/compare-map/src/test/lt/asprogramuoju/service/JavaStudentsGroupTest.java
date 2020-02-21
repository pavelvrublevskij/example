package lt.asprogramuoju.service;

import lt.asprogramuoju.bean.*;
import org.junit.jupiter.api.*;

class JavaStudentsGroupTest {

    private Group group;
    private Student student1;
    private Student student2;

    private final JavaStudentsGroup studentsGroup = new JavaStudentsGroup();

    @BeforeEach
    void setUp() {
        group = new Group("Gr1");
        student1 = new Student(1, "Name", "Surname", 1L);
        student2 = new Student(1, "Name", "Surname", 1L);
    }

//    @Test
//    void () {
//        studentsGroup.setToGroup(group, student1, false);
//        List<Student> students = studentsGroup.getAllData();
//        assertEquals(1, students.size());
//    }
}
