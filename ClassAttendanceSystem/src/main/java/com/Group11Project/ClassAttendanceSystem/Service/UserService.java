package com.Group11Project.ClassAttendanceSystem.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();

    boolean emailExists(String email);
    void deleteStudents();

}
