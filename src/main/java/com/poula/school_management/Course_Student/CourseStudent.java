package com.poula.school_management.Course_Student;

import com.poula.school_management.Course.Course;
import com.poula.school_management.Student.Student;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "course_student")
public class CourseStudent {
    @Embeddable
    public static class CourseStudentId implements Serializable{
        @Column(name = "course_id" ,insertable = false,updatable = false)
        protected Long courseId;

        @Column(name = "student_id",insertable = false,updatable = false)
        protected Long studentId;

        public CourseStudentId(){}

        public CourseStudentId(Long courseId,Long studentId){
            this.courseId = courseId;
            this.studentId = studentId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CourseStudentId that = (CourseStudentId) o;

            if (!courseId.equals(that.courseId)) return false;
            return studentId.equals(that.studentId);
        }

        @Override
        public int hashCode() {
            int result = courseId.hashCode();
            result = 31 * result + studentId.hashCode();
            return result;
        }
    }

    @EmbeddedId
    protected CourseStudentId id = new CourseStudentId();

    @ManyToOne
    @JoinColumn(name = "course_id")
    protected Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    protected Student student;

    public CourseStudent(Course course, Student student){
        this.student = student;
        this.course = course;

        this.id.courseId = course.getId();
        this.id.studentId = student.getId();

        student.getStudentCourses().add(this);
        course.getStudentCourses().add(this);
    }
}
