package com.poula.school_management.Student;

import com.poula.school_management.Course.Course;
import com.poula.school_management.Course.CourseDto;
import com.poula.school_management.Quiz.Quiz_Detail.QuizDetailRepository;
import com.poula.school_management.Shared.PagingDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService{

    protected final StudentRepository studentRepository;
    protected final QuizDetailRepository quizDetailRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository,QuizDetailRepository quizDetailRepository){
        this.studentRepository = studentRepository;
        this.quizDetailRepository =quizDetailRepository;
    }
    @Override
    public ResponseEntity<String> addStudent(StudentDto studentDto) {
        Student newStudent = Student.createNewStudent(studentDto);
        newStudent = studentRepository.save(newStudent);
        return new ResponseEntity<>("student created successfully",HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateStudent(StudentDto studentDto) {
        Student student = studentRepository.findById(studentDto.getId()).orElseThrow();
        student.setPersonalDetails(studentDto.getPersonalDetails());
        student.setAddress(studentDto.getAddress());
        return new ResponseEntity<>("student updated successfully",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PagingDto<StudentDto>> getAllStudents(int pageNumber, int size) {
        Pageable pageable = PageRequest.of(pageNumber,size);
        Page<Student> page = studentRepository.findAll(pageable);
        List<StudentDto> studentDtos = page.get().map(Student::toStudentDto).toList();
        PagingDto<StudentDto> pagingDto = new PagingDto<>();
        pagingDto.setTotalNumber(page.getTotalElements());
        pagingDto.setCurrentPage(pageNumber);
        pagingDto.setEntities(studentDtos);
        pagingDto.setTotalNumberOfPages(page.getTotalPages());
        return new ResponseEntity<>(pagingDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StudentDto> getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        Set<Course> courseSet = studentRepository.getStudentCourses(student);
        List<CourseDto> courses = new ArrayList<>();
        for(Course course :courseSet){
            courses.add(course.toCourseDto());
        }
        StudentDto studentDto = student.toStudentDto();
        studentDto.setCourses(courses);
        return new ResponseEntity<>(studentDto,HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<String> removeStudentById(Long id) {
        quizDetailRepository.deleteByStudentId(id);
        studentRepository.deleteStudentById(id);
        return new ResponseEntity<>("deleted student successfully",HttpStatus.OK);
    }


}
