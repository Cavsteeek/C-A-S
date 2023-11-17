package com.Group11Project.ClassAttendanceSystem.Controller;

import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Model.Teacher;
import com.Group11Project.ClassAttendanceSystem.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cas/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthService authService;

    @PostMapping("/login/student")
    public ResponseEntity<String> studentLogin(@RequestBody LoginRequest loginRequest) {
        Student student = authService.authenticateStudent(loginRequest.getUsername(), loginRequest.getPassword());
        UserDetails userDetails = authService.loadUserByUsername(student.getMatricNumber());
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        String jwt = authService.generateToken(authentication);
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/login/teacher")
    public ResponseEntity<String> teacherLogin(@RequestBody LoginRequest loginRequest) {
        Teacher teacher = authService.authenticateTeacher(loginRequest.getUsername(), loginRequest.getPassword());
        UserDetails userDetails = authService.loadUserByUsername(Integer.toString(teacher.getStaffId()));
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        String jwt = authService.generateToken(authentication);
        return ResponseEntity.ok(jwt);
    }
}
