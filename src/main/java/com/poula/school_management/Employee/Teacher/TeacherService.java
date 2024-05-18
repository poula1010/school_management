package com.poula.school_management.Employee.Teacher;

import com.poula.school_management.Shared.PagingDto;
import org.springframework.http.ResponseEntity;

public interface TeacherService {
    ResponseEntity<String> addTeacher(TeacherDto teacherDto);
    ResponseEntity<TeacherDto> getTeacherById(Long id);

    ResponseEntity<PagingDto<TeacherDto>> getAllTeachers(int pageNumber,int size);

    ResponseEntity<String> deleteTeacherById(Long id);

    ResponseEntity<TeacherDto> updateTeacher(TeacherDto teacherDto);
}
