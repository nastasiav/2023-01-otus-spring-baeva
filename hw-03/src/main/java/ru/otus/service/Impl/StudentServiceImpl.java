package ru.otus.service.Impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.config.QuizProperties;
import ru.otus.model.Student;
import ru.otus.service.InputOutputStreamService;
import ru.otus.service.StudentService;

@Service

public class StudentServiceImpl implements StudentService {

    private final InputOutputStreamService ioService;
    private final MessageSource messageSource;
    private final QuizProperties quizProperties;
    private final int minCountForPass;

    public StudentServiceImpl(InputOutputStreamService ioService, MessageSource messageSource, QuizProperties quizProperties,
                              @Value("${quiz.minCountForPass}") int minCountForPass) {
        this.ioService = ioService;
        this.minCountForPass = minCountForPass;
        this.messageSource = messageSource;
        this.quizProperties = quizProperties;

    }

    @Override
    public Student createStudent() {
        String firstName = ioService.readNextString(messageSource.getMessage("firstName", null,
                quizProperties.getLocale()));
        String lastName = ioService.readNextString(messageSource.getMessage("lastName", null,
                quizProperties.getLocale()));
        return new Student(firstName, lastName, 0);
    }

    @Override
    public void getResult(Student student) {
        String code  = student.getSuccessCount() >= minCountForPass ? "success" : "failed";
        ioService.outputPrint(messageSource.getMessage(code, null, quizProperties.getLocale()));
    }

    @Override
    public void incrementCount(Student student) {
        student.setSuccessCount(student.getSuccessCount() + 1);
    }

}
