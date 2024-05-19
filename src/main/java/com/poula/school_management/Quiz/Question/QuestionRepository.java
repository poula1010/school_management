package com.poula.school_management.Quiz.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    @Modifying
    @Query("DELETE FROM Question Q WHERE Q.id = :questionId")
    public void deleteQuestionById(@Param("questionId") Long questionId);
}
