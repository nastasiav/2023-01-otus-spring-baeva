package ru.otus.domain;

public class User {
    private String firstName;
    private String lastName;
    private int correctAnswerCount;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setCorrectAnswerCount(int correctAnswerCount) {
        this.correctAnswerCount = correctAnswerCount;
    }
}
