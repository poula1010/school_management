package com.poula.school_management.Course;

import com.poula.school_management.Shared.PagingDto;
import com.poula.school_management.Student.Student;
import org.springframework.http.ResponseEntity;

public interface CourseService {

    ResponseEntity<CourseDto> findCourseById(Long id);

    ResponseEntity<PagingDto<CourseDto>> findAllCourses(int pageNumber,int size);

    ResponseEntity<CourseDto> addCourse(CourseDto courseDto);

    ResponseEntity<String> deleteCourseById(Long id);

    ResponseEntity<CourseDto> updateCourse(CourseDto courseDto);


}
