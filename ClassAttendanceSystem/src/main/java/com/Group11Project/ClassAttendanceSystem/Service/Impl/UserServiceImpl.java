package com.Group11Project.ClassAttendanceSystem.Service.Impl;

import com.Group11Project.ClassAttendanceSystem.Repository.StudentRepository;
import com.Group11Project.ClassAttendanceSystem.Repository.TeacherRepository;
import com.Group11Project.ClassAttendanceSystem.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return studentRepository.findByMatricNumber(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}