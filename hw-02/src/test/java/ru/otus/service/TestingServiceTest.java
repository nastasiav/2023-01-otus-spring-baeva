package ru.otus.service;

import org.junit.Test;
import ru.otus.domain.Answer;
import ru.otus.domain.Question;
import ru.otus.handler.CsvHandler;
import ru.otus.service.utils.Console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestingServiceTest extends AppConfig{
    private final Console console = mock(Console.class);
    private final CsvHandler csvHandler = mock(CsvHandler.class);

    private final TestingService testingService = new TestingService(csvHandler, console);

    @Test
    public void test() throws IOException {
        List<Question> questions = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("qwerty"));
        answers.add(new Answer("ytrewq"));
        questions.add(new Question("first", answers,"1"));
        String answer = "qwerty";
        String fName = "username";
        String lName = "secondName";
        when(console.readLine()).thenReturn(fName, lName, answer);
        when(csvHandler.getQuestions()).thenReturn(questions);

        testingService.startTest();
        assertEquals(true, testingService.isSuccess());
    }
}