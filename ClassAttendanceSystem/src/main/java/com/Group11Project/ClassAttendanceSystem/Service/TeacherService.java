package com.Group11Project.ClassAttendanceSystem.Service;

import com.Group11Project.ClassAttendanceSystem.Model.Course;
import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    Optional<Student> findStudentById(Long id);

    //Optional<Teacher> findTeacherById(Long id);
    void deleteStudentById(Long id);

    List<Student> findAllStudents();

    void deleteARById(Long id);

    Course saveCourse(Course course);

    Course updateCourseById(Course course);

    void deleteCourseById(Long id);

    Optional<Course> findCourseById(Long id);

    // Find all courses
    List<Course> findAllCourses();
}
