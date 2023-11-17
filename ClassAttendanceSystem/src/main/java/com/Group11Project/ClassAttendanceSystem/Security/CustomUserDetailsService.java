package com.Group11Project.ClassAttendanceSystem.Security;

import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Model.Teacher;
import com.Group11Project.ClassAttendanceSystem.Repository.StudentRepository;
import com.Group11Project.ClassAttendanceSystem.Repository.TeacherRepository;
import com.Group11Project.ClassAttendanceSystem.Service.util.SecurityUtils;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Attempt to load user as a student
        Student student = studentRepository.findBymatNo(username)
                .orElse(null);

        if (student != null) {
            return UserPrincipal.create(student);
            //return UserPrincipal.builder().build();
        }

        // If not found, attempt to load user as a teacher
        Teacher teacher = teacherRepository.findStaffById(Integer.parseInt(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(username.getRole().name()));
        return UserPrincipal.create(teacher);
        //return UserPrincipal.builder().build();
    }
}

