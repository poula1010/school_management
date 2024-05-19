package com.poula.school_management.Quiz.Question;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {
    ResponseEntity<String> addQuestion(QuestionDto questionDto, Long quizId);

    ResponseEntity<String> deleteQuestion(Long questionId);

    ResponseEntity<String> updateQuestion(QuestionDto questionDto);
}
