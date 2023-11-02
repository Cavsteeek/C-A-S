package com.Group11Project.ClassAttendanceSystem.Service;

import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Model.Teacher;

import java.util.Optional;

public interface TeacherService {
    Optional<Student> findStudentById(Long id);

    Optional<Teacher> findTeacherById(Long id);
    void deleteStudentById(Long id);

}
