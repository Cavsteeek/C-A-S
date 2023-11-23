package com.Group11Project.ClassAttendanceSystem.Service.Impl;

import com.Group11Project.ClassAttendanceSystem.Model.Admin;
import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Model.Role;
import com.Group11Project.ClassAttendanceSystem.Repository.AdminRepository;
import com.Group11Project.ClassAttendanceSystem.Repository.StudentRepository;
import com.Group11Project.ClassAttendanceSystem.Service.AuthenticationService;
import com.Group11Project.ClassAttendanceSystem.Service.JWTService;
import com.Group11Project.ClassAttendanceSystem.dto.JwtAuthenticationResponse;
import com.Group11Project.ClassAttendanceSystem.dto.RefreshTokenRequest;
import com.Group11Project.ClassAttendanceSystem.dto.SignUpRequest;
import com.Group11Project.ClassAttendanceSystem.dto.SigninRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final StudentRepository studentRepository;
    private final AdminRepository adminRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;

    public Student signup(SignUpRequest signUpRequest){
        Student student = new Student();
        student.setEmail(signUpRequest.getEmail());
        student.setFirstname(signUpRequest.getFirstName());
        student.setLastname(signUpRequest.getLastName());
        student.setRole(Role.STUDENT);
        student.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return studentRepository.save(student);
    }

    public JwtAuthenticationResponse Ssignin(SigninRequest signinRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(),
                signinRequest.getPassword()));
        var user = studentRepository.findByEmail(signinRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Username or Password"));
        var jwt = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        return jwtAuthenticationResponse;
    }

    public JwtAuthenticationResponse SrefreshToken(RefreshTokenRequest refreshTokenRequest){
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
        Student student = studentRepository.findByEmail(userEmail).orElseThrow();
        if (jwtService.isTokenValid(refreshTokenRequest.getToken(), student)){
            var jwt = jwtService.generateToken(student);

            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthenticationResponse;
        }
        return null;
    }

    public JwtAuthenticationResponse Asignin(SigninRequest signinRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(),
                signinRequest.getPassword()));
        var admin = adminRepository.findByEmail(signinRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Username or Password"));
        var jwt = jwtService.generateToken(admin);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), admin);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        return jwtAuthenticationResponse;
    }

    public JwtAuthenticationResponse ArefreshToken(RefreshTokenRequest refreshTokenRequest){
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
        Admin admin = adminRepository.findByEmail(userEmail).orElseThrow();
        if (jwtService.isTokenValid(refreshTokenRequest.getToken(), admin)){
            var jwt = jwtService.generateToken(admin);

            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthenticationResponse;
        }
        return null;
    }
}
