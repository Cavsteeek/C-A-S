package com.Group11Project.ClassAttendanceSystem.Controller;

import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Service.AuthenticationService;
import com.Group11Project.ClassAttendanceSystem.dto.JwtAuthenticationResponse;
import com.Group11Project.ClassAttendanceSystem.dto.RefreshTokenRequest;
import com.Group11Project.ClassAttendanceSystem.dto.SignUpRequest;
import com.Group11Project.ClassAttendanceSystem.dto.SigninRequest;
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
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<Student> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/ssignin")
    public ResponseEntity<JwtAuthenticationResponse> ssignin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authenticationService.Ssignin(signinRequest));
    }

    @PostMapping("/srefresh")
    public ResponseEntity<JwtAuthenticationResponse> srefresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok (authenticationService.SrefreshToken(refreshTokenRequest));
    }

    @PostMapping("/asignin")
    public ResponseEntity<JwtAuthenticationResponse> asignin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authenticationService.Asignin(signinRequest));
    }

    @PostMapping("/arefresh")
    public ResponseEntity<JwtAuthenticationResponse> arefresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok (authenticationService.ArefreshToken(refreshTokenRequest));
    }
}
