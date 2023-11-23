package com.Group11Project.ClassAttendanceSystem.Service.Impl;

import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Repository.StudentRepository;
import com.Group11Project.ClassAttendanceSystem.Repository.TeacherRepository;
import com.Group11Project.ClassAttendanceSystem.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    private PasswordEncoder passwordEncoder;

    //public Student signin()
}
