package com.Group11Project.ClassAttendanceSystem.Service;

import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Model.Teacher;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    void deleteTeacherById(Long id);

    void deleteStudentById(Long id);

    Optional<Student> findStudentById(Long id);

    Optional<Teacher> findTeacherById(Long id);

    List<Student> findAllStudents();

    List<Teacher> findAllTeachers();
}
