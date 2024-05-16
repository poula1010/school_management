package com.poula.school_management.Student;

import com.poula.school_management.Course.Course;
import com.poula.school_management.Course_Student.CourseStudent;
import com.poula.school_management.Shared.Address;
import com.poula.school_management.Shared.PersonalDetails;
import jakarta.persistence.*;

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

    @OneToMany(fetch = FetchType.EAGER)
    protected Set<CourseStudent> courses = new HashSet<>();
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

    public Set<CourseStudent> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseStudent> courses) {
        this.courses = courses;
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
}
