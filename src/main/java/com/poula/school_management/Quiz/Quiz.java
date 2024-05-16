package com.poula.school_management.Quiz;

import com.poula.school_management.Course.Course;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",nullable = false)
    protected Course course;
    protected Set<String> questions = new HashSet<>();


}
