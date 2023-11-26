package com.Group11Project.ClassAttendanceSystem.Controller;

import com.Group11Project.ClassAttendanceSystem.Model.Course;
import com.Group11Project.ClassAttendanceSystem.Model.Role;
import com.Group11Project.ClassAttendanceSystem.Model.User;
import com.Group11Project.ClassAttendanceSystem.Repository.CourseRepository;
import com.Group11Project.ClassAttendanceSystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cas/admin")
@RequiredArgsConstructor
@CrossOrigin
public class AdminController {
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Welcome Admin");
    }

    @GetMapping("/get-all-students")
    public ResponseEntity<User> findAllStudents(){
        User studentList = userRepository.findByRole(Role.STUDENT);
        return ResponseEntity.ok(studentList);

    }

    @GetMapping("/get-all-teachers")
    public ResponseEntity<User> findAllTeachers(){
        User teacherList = userRepository.findByRole(Role.TEACHER);
        return ResponseEntity.ok(teacherList);

    }
    /*@DeleteMapping("/delete-all-students")
    public ResponseEntity<Void> deleteAllStudents(){

    }*/
    @GetMapping("/get-all-courses")
    public ResponseEntity<List<Course>> findAllCourse(){
        List<Course> courseList = courseRepository.findAll();
        return ResponseEntity.ok(courseList);
    }
}
