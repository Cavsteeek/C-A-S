package com.Group11Project.ClassAttendanceSystem.Service;

import com.Group11Project.ClassAttendanceSystem.Model.Role;
import com.Group11Project.ClassAttendanceSystem.Model.User;
import com.Group11Project.ClassAttendanceSystem.dto.JwtAuthenticationResponse;
import com.Group11Project.ClassAttendanceSystem.dto.RefreshTokenRequest;
import com.Group11Project.ClassAttendanceSystem.dto.SignUpRequest;
import com.Group11Project.ClassAttendanceSystem.dto.SigninRequest;

public interface AuthenticationService {
    User signup (SignUpRequest signUpRequest, Role role);
    JwtAuthenticationResponse signin(SigninRequest signinRequest);
    User signupAsTeacher(SignUpRequest signUpRequest);
    User signupAsStudent(SignUpRequest signUpRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
