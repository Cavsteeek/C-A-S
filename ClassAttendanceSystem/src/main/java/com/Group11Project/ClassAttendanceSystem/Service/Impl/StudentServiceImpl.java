package com.Group11Project.ClassAttendanceSystem.Service.Impl;

import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Repository.StudentRepository;
import com.Group11Project.ClassAttendanceSystem.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
   /* private PasswordEncoder passwordEncoder;

    @Override
    public Optional<Student> findById(Long id)
    {
        return studentRepository.findById(id);
    }
    @Override
    public Student saveStudent(Student student){
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setCreateTime(LocalDateTime.now());
        return studentRepository.save(student);
    }
    /*@Override
    public Optional<Student> findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }

     */
}
