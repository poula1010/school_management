package com.poula.school_management.Course;

import com.poula.school_management.Course_Student.CourseStudent;
import com.poula.school_management.Employee.Teacher.Teacher;
import com.poula.school_management.Student.Student;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    @Column(nullable = false)
    protected String title;

    @Column(nullable = false,length = 1023)
    protected String description;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
    protected Set<CourseStudent> studentCourses = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    protected Teacher teacher;
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<CourseStudent> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(Set<CourseStudent> studentCourses) {
        this.studentCourses = studentCourses;
    }
}
