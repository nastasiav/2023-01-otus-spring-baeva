package ru.otus.handler;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.service.AppConfig;

import static org.junit.Assert.assertEquals;

@ComponentScan("ru.otus")
public class CsvHandlerTest extends AppConfig {
    @Test
    public void csvHandlerGetQuiz() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(CsvHandlerTest.class);

        CsvHandler csvHandler = context.getBean(CsvHandler.class);

        assertEquals(2, csvHandler.getQuestions().size());
    }

}
