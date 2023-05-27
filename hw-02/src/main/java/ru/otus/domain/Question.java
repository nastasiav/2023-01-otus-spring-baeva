package ru.otus.domain;

import java.util.List;

/**
 * @author: Baeva Nastasia
 */
public class Question {
    private final List<Answer> answers;
    private final String question;
    private final String correctCount;

    public Question(String question, List<Answer> answers, String correctCount) {
        this.answers = answers;
        this.question = question;
        this.correctCount = correctCount;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectCount() {
        return correctCount;
    }
}
