package ru.otus.domain;

/**
 * @author: Baeva Nastasia
 */
public class Answer {
   private final String answer;

    public Answer(String text) {
        this.answer = text;
    }
    @Override
    public String toString() {
        return answer;
    }
}
