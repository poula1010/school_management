package com.poula.school_management.Employee.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    @Modifying
    @Query("DELETE FROM Teacher T Where T.id = :teacherId")
    void deleteTeacherById(@Param("teacherId") Long id);
}
