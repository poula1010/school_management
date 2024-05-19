package com.poula.school_management.Quiz.Question;

import com.poula.school_management.Quiz.Quiz;
import com.poula.school_management.Quiz.QuizRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, QuizRepository quizRepository){
        this.questionRepository = questionRepository;
        this.quizRepository =quizRepository;
    }

    @Override
    public ResponseEntity<String> addQuestion(QuestionDto questionDto, Long quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow();
        Question question = Question.createQuestion(questionDto,quiz);
        questionRepository.save(question);
        return new ResponseEntity<>("question added successfully", HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<String> deleteQuestion(Long questionId) {
        this.questionRepository.deleteQuestionById(questionId);
        return new ResponseEntity<>("question deleted successfully",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateQuestion(QuestionDto questionDto) {
        Question question = questionRepository.findById(questionDto.getId()).orElseThrow();
        question.getOptions().clear();
        for(String option : questionDto.getOptions()){
            question.getOptions().add(option);
        }
        question.setQuestionTitle(questionDto.getTitle());
        question.setMarks(questionDto.getMarks());
        question.setAnswer(questionDto.getAnswer());
        questionRepository.save(question);
        return new ResponseEntity<>("question updated successfully",HttpStatus.OK);
    }
}
