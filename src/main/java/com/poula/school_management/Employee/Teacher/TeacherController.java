package com.poula.school_management.Employee.Teacher;

import com.poula.school_management.Shared.PagingDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long id) {
        return this.teacherService.getTeacherById(id);
    }

    @GetMapping
    public ResponseEntity<PagingDto<TeacherDto>> getAllTeachers(@RequestParam(value = "page", defaultValue = "0") int pageNumber, @RequestParam(value = "size", defaultValue = "10") int size) {
        return this.teacherService.getAllTeachers(pageNumber, size);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable Long id) {
        return this.teacherService.deleteTeacherById(id);
    }
    @PostMapping
    public ResponseEntity<String> addTeacher(@Valid @RequestBody TeacherDto teacherDto){
        return this.teacherService.addTeacher(teacherDto);
    }
    @PutMapping
    public ResponseEntity<TeacherDto> updateTeacher(@RequestBody TeacherDto teacherDto){
        return this.teacherService.updateTeacher(teacherDto);
    }
}