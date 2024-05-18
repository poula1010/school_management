package com.poula.school_management.Quiz;

import com.poula.school_management.Course.Course;
import com.poula.school_management.Quiz.Question.Question;
import com.poula.school_management.Quiz.Quiz_Detail.QuizDetail;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


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
    @OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    protected Set<Question> questions = new HashSet<>();

    @OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    protected Set<QuizDetail> quizDetails = new HashSet<>();
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    protected Timestamp creationTime;

}
