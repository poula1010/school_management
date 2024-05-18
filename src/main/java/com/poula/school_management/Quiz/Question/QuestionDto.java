package com.poula.school_management.Quiz.Question;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.lang.annotation.Native;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class QuestionDto {

    protected Long id;
    @NotNull
    protected String answer;
    @NotNull
    protected String title;
    @NotNull
    @PositiveOrZero
    protected int marks;
    @NotNull
    protected List<String> options = new ArrayList<>();

    public QuestionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String questionTitle) {
        this.title = questionTitle;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
