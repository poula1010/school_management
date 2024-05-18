package com.poula.school_management.Course;

import com.poula.school_management.Shared.PagingDto;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{
    protected final CourseRepository courseRepository;
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository =courseRepository;
    }
    @Override
    public ResponseEntity<CourseDto> findCourseById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow();
        return new ResponseEntity<>(course.toCourseDto(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PagingDto<CourseDto>> findAllCourses(int pageNumber, int size) {
        return null;
    }

    @Override
    public ResponseEntity<CourseDto> addCourse(CourseDto courseDto) {
        Course course = Course.createNewCourse(courseDto);
        course = this.courseRepository.save(course);
        return new ResponseEntity<>(course.toCourseDto(),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteCourseById(Long id) {
        this.courseRepository.deleteCourseById(id);
        return new ResponseEntity<>("course deleted successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CourseDto> updateCourse(CourseDto courseDto){
        Course course = courseRepository.findById(courseDto.getId()).orElseThrow();
        course.setDescription(courseDto.getDescription());
        course.setTitle(courseDto.getDescription());
        course = courseRepository.save(course);
        return new ResponseEntity<>(course.toCourseDto(),HttpStatus.OK);
    }
}
