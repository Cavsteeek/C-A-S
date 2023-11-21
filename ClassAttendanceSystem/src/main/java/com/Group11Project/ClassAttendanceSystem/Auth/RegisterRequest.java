package com.Group11Project.ClassAttendanceSystem.Auth;

import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String fName;

    private String lName;

    private String matricNumber;

    private String password;

    @RestController
    @RequestMapping("/api/v1/cas/auth")
    @RequiredArgsConstructor
    public static class AuthenticationController {
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
}
