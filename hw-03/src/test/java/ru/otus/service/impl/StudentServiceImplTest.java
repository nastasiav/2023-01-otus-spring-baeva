package ru.otus.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.otus.model.Student;
import ru.otus.service.StudentService;

import static org.junit.Assert.assertEquals;

@TestPropertySource("classpath:application-test.yml")
@SpringBootTest()
public class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void increaseRightAnswersCounterTest() {
        Student stud = new Student("firstName", "LastName", 0);
        studentService.incrementCount(stud);
        assertEquals(1, stud.getSuccessCount());
    }
}