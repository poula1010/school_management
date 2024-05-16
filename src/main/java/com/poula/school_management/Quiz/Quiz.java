package com.poula.school_management.Quiz;

import com.poula.school_management.Course.Course;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;


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

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    protected Timestamp creationTime;

}
