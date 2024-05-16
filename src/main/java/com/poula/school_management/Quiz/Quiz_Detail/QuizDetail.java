package com.poula.school_management.Quiz.Quiz_Detail;

import com.poula.school_management.Quiz.Quiz;
import com.poula.school_management.Student.Student;
import jakarta.persistence.*;

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


}
