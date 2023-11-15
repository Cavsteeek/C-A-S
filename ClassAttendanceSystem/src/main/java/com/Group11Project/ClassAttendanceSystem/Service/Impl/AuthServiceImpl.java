package com.Group11Project.ClassAttendanceSystem.Service.Impl;

import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Repository.StudentRepository;
import com.Group11Project.ClassAttendanceSystem.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Configuration
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private StudentRepository studentRepository;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    public Student authenticate(String matricNumber, String password)
    {
        Optional<Student> optionalStudent = studentRepository.findBymatNo(matricNumber);

        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            if (passwordEncoder().matches(password, student.getPassword())){
                return student;
            }
        }
        throw new BadCredentialsException("Invalid Username or password");
    }
}

