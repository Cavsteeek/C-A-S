package com.Group11Project.ClassAttendanceSystem.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String courseCode;

    @OneToMany(mappedBy = "course")
    private List<AttendanceRecord> attendanceRecords;

}
