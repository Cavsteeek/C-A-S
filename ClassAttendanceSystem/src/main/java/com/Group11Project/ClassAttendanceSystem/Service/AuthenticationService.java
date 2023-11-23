package com.Group11Project.ClassAttendanceSystem.Service;

import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.dto.JwtAuthenticationResponse;
import com.Group11Project.ClassAttendanceSystem.dto.RefreshTokenRequest;
import com.Group11Project.ClassAttendanceSystem.dto.SignUpRequest;
import com.Group11Project.ClassAttendanceSystem.dto.SigninRequest;

public interface AuthenticationService {
    Student signup (SignUpRequest signUpRequest);
    JwtAuthenticationResponse Ssignin(SigninRequest signinRequest);
    JwtAuthenticationResponse SrefreshToken(RefreshTokenRequest refreshTokenRequest);
    JwtAuthenticationResponse Asignin(SigninRequest signinRequest);
    JwtAuthenticationResponse ArefreshToken(RefreshTokenRequest refreshTokenRequest);
}
