package com.poula.school_management.Student;

import com.poula.school_management.Course.CourseDto;
import com.poula.school_management.Shared.Address;
import com.poula.school_management.Shared.PagingDto;
import com.poula.school_management.Shared.PersonalDetails;

import java.util.List;

public class StudentDto {

    protected Long id;

    protected PersonalDetails personalDetails;

    protected Address address;

    protected List<CourseDto> courses;
    public StudentDto() {
    }

    public StudentDto(Long id, PersonalDetails personalDetails, Address address) {
        this.id = id;
        this.personalDetails = personalDetails;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }
}
