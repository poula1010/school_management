package com.poula.school_management.Course;

import com.poula.school_management.Shared.PagingDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long courseId){
        return courseService.findCourseById(courseId);
    }

    @GetMapping
    public ResponseEntity<PagingDto<CourseDto>> getAllCourses(@RequestParam(value = "page",defaultValue = "0") int pageNumber,@RequestParam(value = "size",defaultValue = "10") int size){
        return this.courseService.findAllCourses(pageNumber,size);
    }
    @PostMapping
    public ResponseEntity<CourseDto> addCourse(@Valid @RequestBody CourseDto courseDto){
        return this.courseService.addCourse(courseDto);
    }
    @PutMapping
    public ResponseEntity<CourseDto> updateCourse(@Valid @RequestBody CourseDto courseDto){
        return this.courseService.updateCourse(courseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long courseId){
        return this.courseService.deleteCourseById(courseId);
    }
}
