package ru.otus.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.config.QuizProperties;
import ru.otus.model.Question;
import ru.otus.model.Student;
import ru.otus.service.*;

import java.io.FileNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final QuestionService questionService;
    private final FileService fileService;
    private final StudentService studentService;
    private final InputOutputStreamService ioService;
    private final MessageSource messageSource;
    private final QuizProperties quizProps;

    @Override
    public void runQuizTest() {
        ioService.outputPrint(messageSource.getMessage("hallo", null, quizProps.getLocale()));
        Student newStudent = studentService.createStudent();
        runQuiz(newStudent);
    }

    private void runQuiz(Student student) {
        List<Question> questions = null;
        try {
            questions = questionService.getQuestions(fileService.getFromCsv());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ioService.outputPrint(messageSource.getMessage("start", null, quizProps.getLocale()));

        for (Question question : questions) {
            questionService.printQuestion(question);
            boolean isAnswerRight = questionService.checkAnswer(ioService.readNextInt(), question);
            if (isAnswerRight) {
                studentService.incrementCount(student);
            }
        }

        studentService.getResult(student);
    }
}
