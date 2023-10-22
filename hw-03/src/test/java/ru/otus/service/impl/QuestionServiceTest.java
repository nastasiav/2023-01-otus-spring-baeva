package ru.otus.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.model.Question;
import ru.otus.service.Impl.QuestionServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest()
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class QuestionServiceTest {
    @Autowired
    private QuestionServiceImpl questionService;

    @Test
    public void createQuestion() {
        Question question = questionService.getQuestions(getList()).get(0);

        Assert.assertEquals("Q1", question.getQuestion());
        Assert.assertEquals("A1", question.getAnswers().get(0));
        Assert.assertEquals("A2", question.getAnswers().get(1));
        Assert.assertEquals(1, question.getRightAnswerIndex());
    }

    @Test
    public void createQuestionList() {
        List<Question> questions = questionService.getQuestions(getList());
        assertFalse(questions.isEmpty());
        assertEquals(2, questions.size());
    }

    @Test
    public void checkAnswer() {
        List<Question> questions = questionService.getQuestions(getList());
        assertTrue(questionService.checkAnswer(1, questions.get(0)));
    }

    @Test
    public void checkAnswerError() {
        List<Question> questions = questionService.getQuestions(getList());
        assertFalse(questionService.checkAnswer(2, questions.get(0)));
    }

    private List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("Q1;1;A1;A2");
        list.add("Q2;1;A1;A2");
        return list;
    }
}