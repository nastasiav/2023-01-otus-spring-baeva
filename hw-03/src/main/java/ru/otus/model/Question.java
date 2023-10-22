package ru.otus.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Question {
    private String question;
    private List<String> answers;
    private int rightAnswerIndex;
}
