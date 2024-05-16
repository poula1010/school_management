package com.poula.school_management.Quiz;

import com.poula.school_management.Course.Course;
import jakarta.persistence.*;


@Entity
public class Quiz {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;
    @Column(nullable = false)
    protected String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",nullable = false)
    protected Course course;

}
