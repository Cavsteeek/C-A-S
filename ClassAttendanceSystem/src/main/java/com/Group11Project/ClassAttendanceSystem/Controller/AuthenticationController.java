package com.Group11Project.ClassAttendanceSystem.Controller;

import com.Group11Project.ClassAttendanceSystem.Model.Role;
import com.Group11Project.ClassAttendanceSystem.Model.User;
import com.Group11Project.ClassAttendanceSystem.Service.AuthenticationService;
import com.Group11Project.ClassAttendanceSystem.Service.UserService;
import com.Group11Project.ClassAttendanceSystem.dto.JwtAuthenticationResponse;
import com.Group11Project.ClassAttendanceSystem.dto.RefreshTokenRequest;
import com.Group11Project.ClassAttendanceSystem.dto.SignUpRequest;
import com.Group11Project.ClassAttendanceSystem.dto.SigninRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cas/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/Ssignup")
    public ResponseEntity<?> Studentsignup(@RequestBody SignUpRequest signUpRequest) {
        if (userService.emailExists(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body("User with this email already exists");
        }
        return ResponseEntity.ok(authenticationService.signupAsStudent(signUpRequest));
    }

    @PostMapping("/Tsignup")
    public ResponseEntity<?> Teachersignup(@RequestBody SignUpRequest signUpRequest) {
        if (userService.emailExists(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body("User with this email already exists");
        }
        return ResponseEntity.ok(authenticationService.signupAsTeacher(signUpRequest));
    }



    @PostMapping("/Ssignin")
    public ResponseEntity<JwtAuthenticationResponse> Ssignin(@RequestBody SigninRequest signinRequest) {
        JwtAuthenticationResponse user = authenticationService.signin(signinRequest);
        if (user.getRole() != Role.STUDENT) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }

    @PostMapping("/Tsignin")
    public ResponseEntity<JwtAuthenticationResponse> Tsignin(@RequestBody SigninRequest signinRequest) {
        JwtAuthenticationResponse user = authenticationService.signin(signinRequest);
        if (user.getRole() != Role.TEACHER) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }

    @PostMapping("/Asignin")
    public ResponseEntity<JwtAuthenticationResponse> Asignin(@RequestBody SigninRequest signinRequest) {
        JwtAuthenticationResponse user = authenticationService.signin(signinRequest);
        if (user.getRole() != Role.ADMIN) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok (authenticationService.refreshToken(refreshTokenRequest));
    }

}
