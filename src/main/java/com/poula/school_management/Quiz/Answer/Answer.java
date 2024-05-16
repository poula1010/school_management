package com.poula.school_management.Quiz.Answer;

import com.poula.school_management.Quiz.Question.Question;
import com.poula.school_management.Quiz.Quiz_Detail.QuizDetail;
import com.poula.school_management.Student.Student;
import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "question_id",nullable = false)
    protected Question question;

    @ManyToOne
    @JoinColumn(name = "quiz_detail_id",nullable = false)
    protected QuizDetail quizDetail;

    protected String answer;

    public Answer() {
    }

    public Answer(Question question, QuizDetail quizDetail, String answer) {
        this.question = question;
        this.quizDetail = quizDetail;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public QuizDetail getQuizDetail() {
        return quizDetail;
    }

    public void setQuizDetail(QuizDetail quizDetail) {
        this.quizDetail = quizDetail;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
