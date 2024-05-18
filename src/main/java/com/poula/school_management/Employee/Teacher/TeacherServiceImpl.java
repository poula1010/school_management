package com.poula.school_management.Employee.Teacher;

import com.poula.school_management.Shared.MonetaryAmount.MonetaryAmount;
import com.poula.school_management.Shared.PagingDto;
import com.poula.school_management.Student.Student;
import com.poula.school_management.Student.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{
    protected final TeacherRepository teacherRepository;
    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }
    @Override
    public ResponseEntity<String> addTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setAddress(teacherDto.getAddress());
        MonetaryAmount salary = new MonetaryAmount(teacherDto.getSalary());
        teacher.setSalary(salary);
        teacher.setPersonalDetails(teacherDto.getPersonalDetails());
        teacherRepository.save(teacher);
        return new ResponseEntity<>("teacher added successfully " ,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TeacherDto> getTeacherById(Long id) {
        Teacher teacher = this.teacherRepository.findById(id).orElseThrow();
        TeacherDto teacherDto = teacher.toTeacherDto();
        return new ResponseEntity<>(teacherDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PagingDto<TeacherDto>> getAllTeachers(int pageNumber, int size) {
        Pageable pageable = PageRequest.of(pageNumber,size);
        Page<Teacher> page = teacherRepository.findAll(pageable);
        List<TeacherDto> teacherDtos = page.get().map(Teacher::toTeacherDto).toList();
        PagingDto<TeacherDto> pagingDto = new PagingDto<>();
        pagingDto.setTotalNumber(page.getTotalElements());
        pagingDto.setCurrentPage(pageNumber);
        pagingDto.setEntities(teacherDtos);
        pagingDto.setTotalNumberOfPages(page.getTotalPages());
        return new ResponseEntity<>(pagingDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteTeacherById(Long id) {
        teacherRepository.deleteTeacherById(id);
        return new ResponseEntity<>("teacher deleted successfully",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TeacherDto> updateTeacher(TeacherDto teacherDto) {
        Teacher teacher = teacherRepository.findById(teacherDto.getId()).orElseThrow();
        teacher.setPersonalDetails(teacherDto.getPersonalDetails());
        teacher.setSalary(new MonetaryAmount(teacherDto.getSalary()));
        teacher.setAddress(teacherDto.getAddress());
        teacher = teacherRepository.save(teacher);
        return new ResponseEntity<>(teacher.toTeacherDto(),HttpStatus.OK);
    }
}
