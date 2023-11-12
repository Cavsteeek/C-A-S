package com.Group11Project.ClassAttendanceSystem.Service;

import com.Group11Project.ClassAttendanceSystem.Model.Course;
import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Model.Teacher;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    void deleteTeacherById(Long id);

    void deleteStudentById(Long id);

    Optional<Student> findStudentById(Long id);

    Optional<Teacher> findTeacherById(Long id);

    List<Student> findAllStudents();

    List<Teacher> findAllTeachers();

    // Find course by first name
    List<Student> findStudentByfName(String fName);

    // Find student by last name
    List<Student> findStudentBylName(String lName);

    //Delete all students
    void deleteStudents();

    // Delete Attendance Record By id
    void deleteARById(Long id);

    //Delete A whole record
    void deleteRecord();

    // Create Course
    Course saveCourse(Course course);

    ResponseEntity<Course> updateCourseById(Long id, Course course);

    // Delete Course By Id
    void deleteCourseById(Long id);

    //Find course By id
    Optional<Course> findCourseById(Long id);

    // Find course by name
    List<Course> findBycName(String cName);

    // Find course by title
    List<Course> findCourseByTitle(String cTitle);

    // Find all courses
    List<Course> findAllCourses();

    //Delete all courses
    void deleteCourses();

    void deleteAllTeachers();
}
