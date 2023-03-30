package ru.otus.domain;

import java.util.List;

/**
 * @author: Baeva Nastasia
 */
public class Question {
    private final List<Answer> answers;
    private final String question;

    public Question(String question, List<Answer> answers) {
        this.answers = answers;
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String getQuestion() {
        return question;
    }
}
