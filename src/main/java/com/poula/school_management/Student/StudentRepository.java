package com.poula.school_management.Student;

import com.poula.school_management.Course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Modifying
    @Query("Delete from Student S where S.id = :studentId")
    public void deleteStudentById(@Param("studentId") Long id);

    @Query("Select C FROM Course C WHERE C IN (SELECT CS.course FROM CourseStudent CS WHERE CS.student = :student)")
    Set<Course> getStudentCourses(@Param("student") Student student);
}
