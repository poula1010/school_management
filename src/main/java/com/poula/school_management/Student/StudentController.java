package com.poula.school_management.Student;

import com.poula.school_management.Course.CourseDto;
import com.poula.school_management.Shared.PagingDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    protected final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") Long id){
        return this.studentService.getStudentById(id);
    }

    @GetMapping("")
    public ResponseEntity<PagingDto<StudentDto>> getAllStudents(@RequestParam(name = "page",defaultValue ="0") int pageNumber,
                                                                @RequestParam(name = "size",defaultValue = "10") int size){
        return this.studentService.getAllStudents(pageNumber,size);
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@Valid @RequestBody StudentDto studentDto){
        return this.studentService.addStudent(studentDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeStudentById(@PathVariable("id") Long id){
        return this.studentService.removeStudentById(id);
    }

    @PutMapping
    public ResponseEntity<String> updateStudent(@Valid @RequestBody StudentDto studentDto){
        return this.studentService.updateStudent(studentDto);
    }
}
