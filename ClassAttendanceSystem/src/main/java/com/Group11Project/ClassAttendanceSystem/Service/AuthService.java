package com.Group11Project.ClassAttendanceSystem.Service;

import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Model.Teacher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {
    UserDetails loadUserByUsername(String username);

    String generateToken(Authentication authentication);

    Student authenticateStudent(String matricNumber, String password);

    Teacher authenticateTeacher(int staffId, String password);
}
