package ru.otus.service;

import ru.otus.domain.Question;
import ru.otus.handler.CsvHandler;

import java.util.List;
import java.util.Scanner;

/**
 * @author: Baeva Nastasia
 */
public class TestingService {
    private static final String GREETING = "Test is beginning";
    private static final String GOODBAY = "Test was ending";
    private static final String GET_ANSWER = "Waiting your answer: ";
    private CsvHandler csvHandler;

    public TestingService(CsvHandler csvHandler) {
        this.csvHandler = csvHandler;
    }

    public void startTest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(GREETING);

        for (Question question : csvHandler.getQuestions()) {
            System.out.println(question.getQuestion());
            question.getAnswers().stream()
                    .forEach(System.out::println);
            System.out.println(GET_ANSWER);
            scanner.nextLine();
        }

        System.out.println(GOODBAY);
    }

}
