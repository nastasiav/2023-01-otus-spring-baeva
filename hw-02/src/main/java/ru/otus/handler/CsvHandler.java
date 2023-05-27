package ru.otus.handler;

import org.springframework.stereotype.Component;
import ru.otus.domain.Answer;
import ru.otus.domain.Question;
import ru.otus.service.ResourceService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Baeva Nastasia
 */
@Component
public class CsvHandler {
    private static final String separator = ";";
    private final ResourceService resourceService;
    private final List<Question> questions;

    public CsvHandler(ResourceService resourceService) {
        this.resourceService = resourceService;
        this.questions = new ArrayList<>();
    }

    private void initQuestions() {

        try {
            List<List<String>> list = resourceService.getFromCsv(separator);
            for (List<String> lister : list) {
                String correctCount = lister.get(1);
                List<Answer> answersList = lister.subList(2, lister.size())
                        .stream()
                        .map(answer -> new Answer(answer))
                        .toList();
                this.questions.add(new Question(lister.get(0), answersList, correctCount));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Question> getQuestions() {
        initQuestions();
        return questions;
    }
}
