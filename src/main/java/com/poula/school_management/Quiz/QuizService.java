package com.poula.school_management.Quiz;

import org.springframework.http.ResponseEntity;

public interface QuizService {

    ResponseEntity<String> addQuiz(QuizDto quizDto,Long courseId);
    ResponseEntity<String> deleteQuiz(Long quizId);
}
