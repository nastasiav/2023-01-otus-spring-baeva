package ru.otus.handler;

import org.junit.Test;
import ru.otus.service.ResourceService;

import static org.junit.Assert.assertEquals;

public class CsvHandlerTest {

    private ResourceService resourceService;
    private CsvHandler csvHandler;

    public CsvHandlerTest() {
        this.resourceService = new ResourceService("quizTest.csv");
        this.csvHandler = new CsvHandler(this.resourceService);
    }

    @Test
    public void csvHandlerGetQuiz() {
        assertEquals(2, csvHandler.getQuestions().size());
    }

}
