package ru.otus.service;

import ru.otus.model.Student;

public interface StudentService {
    Student createStudent();

    void getResult(Student studentDto);

    void incrementCount(Student studentDto);
}
