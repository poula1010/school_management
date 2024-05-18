package com.poula.school_management.Employee.Teacher;

import com.poula.school_management.Course_Teacher.CourseTeacher;
import com.poula.school_management.Employee.Employee;
import com.poula.school_management.Shared.Address;
import com.poula.school_management.Shared.MonetaryAmount.MonetaryAmount;
import com.poula.school_management.Shared.PersonalDetails;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher extends Employee {

    @OneToMany(mappedBy = "teacher",fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Set<CourseTeacher> teacherCourses =new HashSet<>();
    public Teacher(PersonalDetails personalDetails, Address address, MonetaryAmount salary){
        super(personalDetails,address,salary);
    }
    public Teacher(){}

    public Set<CourseTeacher> getTeacherCourses() {
        return teacherCourses;
    }

    public void setTeacherCourses(Set<CourseTeacher> teacherCourses) {
        this.teacherCourses = teacherCourses;
    }

    public TeacherDto toTeacherDto(){
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(this.getId());
        teacherDto.setAddress(this.getAddress());
        teacherDto.setSalary(this.getSalary().asBigDecimal());
        teacherDto.setPersonalDetails(this.getPersonalDetails());
        return teacherDto;
    }

}
