package com.poula.school_management.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Modifying
    @Query("Delete from Student S where S.id = :studentId")
    public void deleteStudentById(@Param("studentId") Long id);
}
