package ru.otus.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "quiz")
public class QuizProperties {
    private final Locale locale;
    private final int minPerForPass;
    private final String csvFile;
    private final int countQuestions;
}