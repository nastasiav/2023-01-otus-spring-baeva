package ru.otus.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.domain.Question;
import ru.otus.domain.User;
import ru.otus.handler.CsvHandler;
import ru.otus.service.utils.Console;

import java.io.IOException;
import java.util.List;

/**
 * @author: Baeva Nastasia
 */
//@Service
@Service
public class TestingService {
    private final CsvHandler csvHandler;

    private final Console console;

    @Value("${greeting}")
    private String greeting;

    @Value("${goodbye}")
    private String goodbye;

    @Value("${successMessage}")
    private String successMessage;

    @Value("${failMessage}")
    private String failMessage;

    @Value("${success}")
    private int result;

    @Value("${getFirstNameMsg}")
    private String getFirstName;

    @Value("${getLastNameMsg}")
    private String getLastName;

    private boolean isSuccess = false;

    public boolean isSuccess() {
        return isSuccess;
    }

    public TestingService(CsvHandler csvHandler, Console console) {
        this.csvHandler = csvHandler;
        this.console = console;
    }

    public void startTest() throws IOException {
        console.println(greeting);

        console.println(getFirstName);
        String firstName = console.readLine();
        console.println(getLastName);
        String lastName = console.readLine();

        User user = new User(firstName, lastName);

        int correct = 0;
        List<Question> questions = csvHandler.getQuestions();

        for (Question question : questions) {
            console.println(question.getQuestion());
            question.getAnswers().stream().forEach(console::println);
            String answer = console.readLine();

            if (answer.equals(question.getCorrectCount()))
                correct++;
        }
        user.setCorrectAnswerCount(correct);

        isSuccess = correct >= result ? true : false;
        console.println(isSuccess ? successMessage : failMessage);

        console.println(goodbye);
    }

}
