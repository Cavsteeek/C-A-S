package com.Group11Project.ClassAttendanceSystem.Controller;

import com.Group11Project.ClassAttendanceSystem.Model.Role;
import com.Group11Project.ClassAttendanceSystem.Model.User;
import com.Group11Project.ClassAttendanceSystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cas/teacher")
@RequiredArgsConstructor
@CrossOrigin
public class TeacherController
{
    private final UserRepository userRepository;
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Welcome Teacher");
    }

    @GetMapping("/get-all-students")
    public ResponseEntity<List<User>> findAllStudents(){
        List<User> studentList = userRepository.findByRolee(Role.STUDENT);
        return ResponseEntity.ok(studentList);

    }

}
