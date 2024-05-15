package com.poula.school_management.Course;

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

}
