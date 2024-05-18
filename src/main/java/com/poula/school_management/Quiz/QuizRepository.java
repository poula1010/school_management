package com.poula.school_management.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

    @Modifying
    @Query("DELETE FROM Quiz Q WHERE Q.id = :quizId")
    void deleteQuizById(@Param("quizId") Long id);
}
