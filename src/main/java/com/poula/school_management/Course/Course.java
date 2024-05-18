package com.poula.school_management.Course;

import com.poula.school_management.Course_Student.CourseStudent;
import com.poula.school_management.Course_Teacher.CourseTeacher;
import com.poula.school_management.Employee.Teacher.Teacher;
import com.poula.school_management.Quiz.Quiz;
import com.poula.school_management.Student.Student;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    @Column(nullable = false)
    protected String title;

    @Column(nullable = false,length = 1023)
    protected String description;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    protected Set<CourseStudent> studentCourses = new HashSet<>();

    @OneToMany(mappedBy = "course" , fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    protected Set<CourseTeacher> teacherCourses = new HashSet<>();

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    protected Set<Quiz> quizzes = new HashSet<>();
    public Long getId() {
        return id;
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


    public Set<CourseStudent> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(Set<CourseStudent> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public Set<CourseTeacher> getTeacherCourses() {
        return teacherCourses;
    }

    public void setTeacherCourses(Set<CourseTeacher> teacherCourses) {
        this.teacherCourses = teacherCourses;
    }

    public Set<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Set<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public static Course createNewCourse(CourseDto courseDto){
        Course course = new Course();
        course.setDescription(course.getDescription());
        course.setTitle(courseDto.getTitle());
        return course;
    }
    public CourseDto toCourseDto(){
        CourseDto courseDto = new CourseDto();
        courseDto.setDescription(this.getDescription());
        courseDto.setTitle(this.getTitle());
        courseDto.setId(this.getId());
        return courseDto;
    }
}
