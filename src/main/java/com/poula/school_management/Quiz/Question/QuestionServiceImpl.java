package com.poula.school_management.Quiz.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    @Override
    public void addQuestion(QuestionDto questionDto, Long quizId) {

    }

    @Override
    public void addQuestions(List<QuestionDto> questions, Long quizId) {

    }
}
