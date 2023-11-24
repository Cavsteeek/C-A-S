package com.Group11Project.ClassAttendanceSystem.Controller;

import com.Group11Project.ClassAttendanceSystem.Model.Role;
import com.Group11Project.ClassAttendanceSystem.Model.User;
import com.Group11Project.ClassAttendanceSystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cas/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserRepository userRepository;
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Welcome Admin");
    }

    @GetMapping("/get-all-students")
    public ResponseEntity<List<User>> findAllStudents(){
        List<User> studentList = userRepository.findByRole(Role.STUDENT);
        return ResponseEntity.ok(studentList);

    }
}
