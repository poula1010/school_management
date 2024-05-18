package com.poula.school_management.Quiz;

import com.poula.school_management.Course.Course;
import com.poula.school_management.Course.CourseRepository;
import com.poula.school_management.Quiz.Question.Question;
import com.poula.school_management.Quiz.Question.QuestionDto;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{

    protected final QuizRepository quizRepository;
    protected final CourseRepository courseRepository;

    public QuizServiceImpl(QuizRepository quizRepository,CourseRepository courseRepository){
        this.quizRepository = quizRepository;
        this.courseRepository = courseRepository;
    }
    @Override
    @Transactional
    public ResponseEntity<String> addQuiz(QuizDto quizDto,Long CourseId) {
        Course course = courseRepository.findById(CourseId).orElseThrow();
        Quiz quiz = Quiz.createQuiz(quizDto,course);
        List<Question> questions = new ArrayList<>();
        for(QuestionDto questionDto : quizDto.getQuestions()){
            Question question = Question.createQuestion(questionDto,quiz);
            questions.add(question);
        }
        quizRepository.save(quiz);
        return new ResponseEntity<>("Quiz added successfully", HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public ResponseEntity<String> deleteQuiz(Long quizId) {
        quizRepository.deleteQuizById(quizId);
        return new ResponseEntity<>("Quiz deleted successfully",HttpStatus.OK);
    }
}
