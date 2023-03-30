package ru.otus.handler;

import ru.otus.domain.Answer;
import ru.otus.domain.Question;
import ru.otus.service.ResourceService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Baeva Nastasia
 */
public class CsvHandler {
    private static final String separator = ";";
    private final ResourceService resourceService;
    private final List<Question> questions;

    public CsvHandler(ResourceService resourceService) {
        this.resourceService = resourceService;
        this.questions = new ArrayList<>();
        initQuestions();
    }

    private void initQuestions() {
        try {
            List<List<String>> list = resourceService.getFromCsv(separator);
            for (List<String> lister : list) {
                List<Answer> answersList = lister.subList(1, lister.size())
                        .stream()
                        .map(answer -> new Answer(answer.toString()))
                        .toList();
                this.questions.add(new Question(lister.get(0), answersList));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
