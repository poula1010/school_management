package com.poula.school_management.Quiz.Question;

import java.util.List;

public interface QuestionService {
    void addQuestion(QuestionDto questionDto,Long quizId);

    void addQuestions(List<QuestionDto> questions,Long quizId);
}
