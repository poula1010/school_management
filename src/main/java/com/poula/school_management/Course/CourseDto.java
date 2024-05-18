package com.poula.school_management.Course;

import jakarta.validation.constraints.NotNull;

public class CourseDto {

    protected Long id;
    @NotNull
    protected String title;

    @NotNull
    protected String description;

    public CourseDto() {
    }

    public CourseDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
