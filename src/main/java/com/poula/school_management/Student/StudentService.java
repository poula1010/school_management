package com.poula.school_management.Student;

import com.poula.school_management.Shared.PagingDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
        ResponseEntity<String> addStudent(StudentDto studentDto);
    ResponseEntity<String> updateStudent(StudentDto studentDto);

    ResponseEntity<PagingDto<StudentDto>> getAllStudents(int pageNumber, int size);
    ResponseEntity<StudentDto> getStudentById(Long id);
    ResponseEntity<String> removeStudentById(Long id);

}
