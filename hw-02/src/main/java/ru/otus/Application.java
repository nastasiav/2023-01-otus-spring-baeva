package ru.otus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.service.TestingService;

import java.io.IOException;

@Configuration("ru.otus")
@ComponentScan
public class Application {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        TestingService testingService = context.getBean(TestingService.class);
        testingService.startTest();
    }
}