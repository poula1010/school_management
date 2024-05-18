package com.poula.school_management.Quiz;

import com.poula.school_management.Quiz.Question.QuestionDto;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public class QuizDto {

    protected Long id;
    @NotNull
    protected String description;

    @NotNull
    protected List<QuestionDto> questions;

    protected Timestamp creationTime;

    protected int totalMarks;

    public QuizDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }
}
