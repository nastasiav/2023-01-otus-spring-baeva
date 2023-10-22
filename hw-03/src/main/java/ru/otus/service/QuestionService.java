package ru.otus.service;

import ru.otus.model.Question;

import java.util.List;

public interface QuestionService {
    void printQuestion(Question question);

    boolean checkAnswer(int answerNumber, Question question);

    List<Question> getQuestions(List<String> questionData);
}
