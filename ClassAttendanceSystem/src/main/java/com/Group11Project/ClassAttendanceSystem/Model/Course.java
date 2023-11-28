package com.Group11Project.ClassAttendanceSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String courseCode;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<AttendanceRecord> attendanceRecords;

}
