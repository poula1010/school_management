package com.poula.school_management.Student;

import com.poula.school_management.Course.Course;
import com.poula.school_management.Course_Student.CourseStudent;
import com.poula.school_management.Quiz.Quiz_Detail.QuizDetail;
import com.poula.school_management.Shared.Address;
import com.poula.school_management.Shared.PersonalDetails;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;
    @Embedded
    protected PersonalDetails personalDetails;

    @Embedded
    protected Address address;

    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    protected Set<CourseStudent> studentCourses = new HashSet<>();

    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    protected Set<QuizDetail> quizDetails;
    public Student() {
    }

    public Student(PersonalDetails personalDetails, Address address) {
        this.personalDetails = personalDetails;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<CourseStudent> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(Set<CourseStudent> studentCourses) {
        this.studentCourses = studentCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!getId().equals(student.getId())) return false;
        if (!getPersonalDetails().equals(student.getPersonalDetails())) return false;
        return getAddress().equals(student.getAddress());
    }

    @Override
    public int hashCode() {
        return getPersonalDetails().hashCode();
    }
    public static Student createNewStudent(StudentDto studentDto){
        Student student = new Student();
        student.setAddress(studentDto.getAddress());
        student.setPersonalDetails(studentDto.getPersonalDetails());
        return student;
    }

    public StudentDto toStudentDto(){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(this.getId());
        studentDto.setAddress(this.getAddress());
        studentDto.setPersonalDetails(this.getPersonalDetails());
        return studentDto;
    }
}
