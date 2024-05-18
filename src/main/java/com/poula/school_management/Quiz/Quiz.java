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
    @OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST})
    @OnDelete(action = OnDeleteAction.CASCADE)
    protected Set<Question> questions = new HashSet<>();

    @OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST})
    @OnDelete(action = OnDeleteAction.CASCADE)
    protected Set<QuizDetail> quizDetails = new HashSet<>();
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    protected Timestamp creationTime;

    public Quiz() {
    }

    public Quiz(String description, Course course) {
        this.description = description;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
        course.getQuizzes().add(this);
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<QuizDetail> getQuizDetails() {
        return quizDetails;
    }

    public void setQuizDetails(Set<QuizDetail> quizDetails) {
        this.quizDetails = quizDetails;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public static Quiz createQuiz(QuizDto quizDto,Course course){
        Quiz quiz = new Quiz();
        quiz.setDescription(quizDto.getDescription());
        quiz.setCourse(course);
        return quiz;
    }
}
