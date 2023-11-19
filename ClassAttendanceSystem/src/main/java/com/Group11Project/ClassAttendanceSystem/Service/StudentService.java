package com.Group11Project.ClassAttendanceSystem.Service;

public interface StudentService {
    Role saveRole(Role role);
    void addRoleToStudent(String matricNumber, String roleName);
}
