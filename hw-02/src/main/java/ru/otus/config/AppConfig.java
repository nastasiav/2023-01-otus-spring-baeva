package ru.otus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:quiz.properties")
public class AppConfig {
    private final String pathToQuiz;

    public AppConfig(@Value("${quizFilePath}") String pathToQuiz) {
        this.pathToQuiz = pathToQuiz;
    }

    public String getPathToQuiz() {
        return pathToQuiz;
    }
}
