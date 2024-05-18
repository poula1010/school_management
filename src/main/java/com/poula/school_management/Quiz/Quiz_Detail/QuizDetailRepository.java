package com.poula.school_management.Quiz.Quiz_Detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuizDetailRepository extends JpaRepository<QuizDetail,Long> {
    @Modifying
    @Query("Delete from QuizDetail qd where qd.student.id = :studentId")
    void deleteByStudentId(@Param("studentId") Long studentId);


}
