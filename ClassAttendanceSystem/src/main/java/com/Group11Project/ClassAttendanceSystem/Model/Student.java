package com.Group11Project.ClassAttendanceSystem.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fName;
    private String lName;
    private String matricNumber;
    @Column(nullable = false, length = 8, name = "stdnt_password")
    private String password;
    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;


}
