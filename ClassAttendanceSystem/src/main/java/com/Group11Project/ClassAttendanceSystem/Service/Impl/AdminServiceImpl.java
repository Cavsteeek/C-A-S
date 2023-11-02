package com.Group11Project.ClassAttendanceSystem.Service.Impl;

import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Model.Teacher;
import com.Group11Project.ClassAttendanceSystem.Repository.AdminRepository;
import com.Group11Project.ClassAttendanceSystem.Repository.StudentRepository;
import com.Group11Project.ClassAttendanceSystem.Repository.TeacherRepository;
import com.Group11Project.ClassAttendanceSystem.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final AdminRepository adminRepository;

    @Override
    public void deleteTeacherById(Long id)
    {
        teacherRepository.deleteById(id);
    }
    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
    @Override
    public Optional<Student> findStudentById(Long id)
    {
        return studentRepository.findById(id);
    }
    @Override
    public Optional<Teacher> findTeacherById(Long id)
    {
        return teacherRepository.findById(id);
    }



}
