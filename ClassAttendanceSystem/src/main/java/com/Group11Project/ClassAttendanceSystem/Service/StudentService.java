package com.Group11Project.ClassAttendanceSystem.Service;

import com.Group11Project.ClassAttendanceSystem.Model.Role;
import com.Group11Project.ClassAttendanceSystem.Model.Student;

import java.util.Optional;

public interface StudentService {
    Role saveRole(Role role);
    void addRoleToStudent(String matricNumber, String roleName);
}
