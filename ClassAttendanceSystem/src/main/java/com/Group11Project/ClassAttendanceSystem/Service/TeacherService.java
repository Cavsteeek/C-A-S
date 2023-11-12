package com.Group11Project.ClassAttendanceSystem.Service;

import com.Group11Project.ClassAttendanceSystem.Model.Course;
import com.Group11Project.ClassAttendanceSystem.Model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    Optional<Student> findStudentById(Long id);

    void deleteStudentById(Long id);

    List<Student> findAllStudents();

    // Find course by name
    List<Student> findStudentByfName(String fName);

    // Find course by name
    List<Student> findStudentBylName(String lName);

    //Delete all students
    void deleteStudents();

    void deleteARById(Long id);

    void deleteRecord();

    public Course saveCourse(Course course);

    ResponseEntity<Course> updateCourseById(Long id, Course course);

    void deleteCourseById(Long id);

    Optional<Course> findCourseById(Long id);

    List<Course> findBycName(String cName);

    // Find course by title
    List<Course> findCourseByTitle(String cTitle);

    // Find all courses
    List<Course> findAllCourses();

    //Delete all courses
    void deleteCourses();

}
