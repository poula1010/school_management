package com.poula.school_management.Quiz.Quiz_Detail;

import com.poula.school_management.Quiz.Answer.Answer;
import com.poula.school_management.Quiz.Quiz;
import com.poula.school_management.Student.Student;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

@Entity
public class QuizDetail {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    protected Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "student_id")
    protected Student student;

    @OneToMany(mappedBy = "quizDetail")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Set<Answer> answers = new HashSet<>();
}
