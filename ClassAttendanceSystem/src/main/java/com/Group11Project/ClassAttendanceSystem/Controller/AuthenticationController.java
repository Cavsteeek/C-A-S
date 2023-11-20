package com.Group11Project.ClassAttendanceSystem.Controller;

import com.Group11Project.ClassAttendanceSystem.Auth.AuthenticationRequest;
import com.Group11Project.ClassAttendanceSystem.Auth.AuthenticationResponse;
import com.Group11Project.ClassAttendanceSystem.Auth.AuthenticationService;
import com.Group11Project.ClassAttendanceSystem.Auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cas/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("studentRegister")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
            ){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/studentLogin")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }

   /* @PostMapping("/teacher/login")
    public ResponseEntity<AuthenticationResponse> tlogin(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }*/

    /* @PostMapping("teacher/register")
    public ResponseEntity<AuthenticationResponse> tregister(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.register(request));
    }*/

}
