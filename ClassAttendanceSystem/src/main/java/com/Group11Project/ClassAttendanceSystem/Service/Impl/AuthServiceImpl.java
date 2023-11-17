package com.Group11Project.ClassAttendanceSystem.Service.Impl;

import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Model.Teacher;
import com.Group11Project.ClassAttendanceSystem.Repository.StudentRepository;
import com.Group11Project.ClassAttendanceSystem.Repository.TeacherRepository;
import com.Group11Project.ClassAttendanceSystem.Security.UserPrincipal;
import com.Group11Project.ClassAttendanceSystem.Security.jwt.JwtProvider;
import com.Group11Project.ClassAttendanceSystem.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
//@NoArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final JwtProvider tokenProvider;

    @Override
    public UserDetails loadUserByUsername(String username) {

        Optional<Student> studentOptional = studentRepository.findBymatNo(username);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            return UserPrincipal.create(student);
        }

        Optional<Teacher> teacherOptional = teacherRepository.findStaffById(Integer.parseInt(username));
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();
            return UserPrincipal.create(teacher);
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }

    @Override
    public String generateToken(Authentication authentication) {
        return tokenProvider.generateToken(authentication);
    }

    @Override
    public Student authenticateStudent(String matricNumber, String password) {
        Optional<Student> studentOptional = studentRepository.findBymatNo(matricNumber);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            // You may want to use a password encoder here to compare passwords
            if (password.equals(student.getPassword())) {
                return student;
            }
        }
        throw new BadCredentialsException("Invalid credentials for student");
    }

    @Override
    public Teacher authenticateTeacher(int staffId, String password) {
        Optional<Teacher> teacherOptional = teacherRepository.findStaffById(staffId);
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();
            // You may want to use a password encoder here to compare passwords
            if (password.equals(teacher.getPassword())) {
                return teacher;
            }
        }
        throw new BadCredentialsException("Invalid credentials for teacher");
    }
}

