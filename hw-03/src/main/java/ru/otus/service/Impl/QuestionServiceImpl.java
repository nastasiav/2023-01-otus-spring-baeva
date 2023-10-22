package ru.otus.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.model.Question;
import ru.otus.service.InputOutputStreamService;
import ru.otus.service.QuestionService;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final InputOutputStreamService ioService;
    private List<Question> questions;

    @Override
    public void printQuestion(Question question) {
        List<String> answers = question.getAnswers();
        ioService.outputPrint(question.getQuestion());
        for (int i = 0; i < answers.size(); i++) {
            ioService.outputPrint((i + 1) + ". " + answers.get(i));
        }
    }

    @Override
    public boolean checkAnswer(int answerNumber, Question question) {
        return answerNumber == question.getRightAnswerIndex();
    }

    @Override
    public List<Question> getQuestions(List<String> questionData) {
        if (questions == null)
            createQuestionsList(questionData);
        return questions;
    }

    private Question createQuestion(String questionString) {
        String[] questionData = questionString.split(";");
        Question question = new Question();

        question.setQuestion(questionData[0]);
        question.setRightAnswerIndex(Integer.parseInt(questionData[1]));
        setAnswers(questionData, question);

        return question;
    }

    private void setAnswers(String[] questionData, Question questionDto) {
        List<String> answers = new ArrayList<>();
        for (int i = 2; i < questionData.length; i++) {
            answers.add(questionData[i]);
        }
        questionDto.setAnswers(answers);
    }

    private void createQuestionsList(List<String> questionData) {
        questions = new ArrayList<>();
        if (questionData.size() > 0) {
            questionData.forEach(el -> questions.add(createQuestion(el)));
        }
    }

}
