package com.poula.school_management.Quiz;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    protected final QuizService quizService;
    @Autowired
    public QuizController(QuizService quizService){
        this.quizService = quizService;
    }
    @PostMapping
    public ResponseEntity<String> addQuiz(@Valid @RequestBody QuizDto quizDto, @RequestParam(name = "courseId") Long courseId){
        return quizService.addQuiz(quizDto,courseId);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuizById(@PathVariable Long id){
        return quizService.deleteQuiz(id);
    }
}
