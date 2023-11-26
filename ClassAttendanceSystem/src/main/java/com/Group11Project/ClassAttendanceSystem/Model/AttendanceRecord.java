package com.Group11Project.ClassAttendanceSystem.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "attendance_record")
public class AttendanceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    private Date Date;

    private Integer courseId;

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }



}
