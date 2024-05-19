package com.poula.school_management.Quiz.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    protected final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }
    @PostMapping
    public ResponseEntity<String> addQuestionToQuiz(@RequestBody QuestionDto questionDto, @RequestParam("quizId") Long quizId){
        return this.questionService.addQuestion(questionDto,quizId);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestionById(@PathVariable Long id){
        return this.questionService.deleteQuestion(id);
    }

    @PutMapping
    public ResponseEntity<String> updateQuestion(@RequestBody QuestionDto questionDto){
        return this.questionService.updateQuestion(questionDto);
    }
}
