package com.poula.school_management.Course;

import com.poula.school_management.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface CourseRepository extends JpaRepository<Course,Long> {
    @Modifying
    @Query("DELETE FROM Course C WHERE C.id = :courseId")
    void deleteCourseById(@Param("courseId") Long courseId);


}
