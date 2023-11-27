package com.Group11Project.ClassAttendanceSystem.Controller;

import com.Group11Project.ClassAttendanceSystem.Model.Course;
import com.Group11Project.ClassAttendanceSystem.Model.Role;
import com.Group11Project.ClassAttendanceSystem.Model.User;
import com.Group11Project.ClassAttendanceSystem.Repository.CourseRepository;
import com.Group11Project.ClassAttendanceSystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/get-all-users-by-role/{role}")
    public ResponseEntity<List<User>> getAllUsersByRole(@PathVariable Role role) {
        try {
            List<User> userList = userRepository.findAllByRole(role);
            return ResponseEntity.ok(userList);
        } catch (Exception e) {
            // Log the exception or return a custom error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
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
