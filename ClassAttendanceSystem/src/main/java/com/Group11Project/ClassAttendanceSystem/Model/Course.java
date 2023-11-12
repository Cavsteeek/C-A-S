package com.Group11Project.ClassAttendanceSystem.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "c_name", nullable = false)
    private String cName;
    @Column(name = "c_title", nullable = false)
    private String cTitle;

    @ManyToMany
    private List<Student> students;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AttendanceRecord> attendanceRecords;

}
