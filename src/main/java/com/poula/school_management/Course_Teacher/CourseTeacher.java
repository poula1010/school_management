package com.poula.school_management.Course_Teacher;

import com.poula.school_management.Course.Course;
import com.poula.school_management.Course_Student.CourseStudent;
import com.poula.school_management.Employee.Teacher.Teacher;
import com.poula.school_management.Student.Student;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "course_teacher")
public class CourseTeacher {

    @Embeddable
    public static class CourseTeacherId implements Serializable {
        @Column(name = "course_id" ,insertable = false,updatable = false)
        protected Long courseId;

        @Column(name = "teacher_id",insertable = false,updatable = false)
        protected Long teacherId;

        public CourseTeacherId(){}

        public CourseTeacherId(Long courseId,Long studentId){
            this.courseId = courseId;
            this.teacherId = studentId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CourseTeacherId that = (CourseTeacherId) o;

            if (!courseId.equals(that.courseId)) return false;
            return teacherId.equals(that.teacherId);
        }

        @Override
        public int hashCode() {
            int result = courseId.hashCode();
            result = 31 * result + teacherId.hashCode();
            return result;
        }
    }

    @EmbeddedId
    protected CourseTeacherId id= new CourseTeacherId();
    @ManyToOne
    @JoinColumn(name = "course_id")
    protected Course course;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    protected Teacher teacher;

    public CourseTeacher(Course course, Teacher teacher){
        this.teacher = teacher;
        this.course = course;

        this.id.courseId = course.getId();
        this.id.teacherId = teacher.getId();

    }
}
