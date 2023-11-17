package com.Group11Project.ClassAttendanceSystem.Security;

import com.Group11Project.ClassAttendanceSystem.Model.Student;
import com.Group11Project.ClassAttendanceSystem.Model.Teacher;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
public class UserPrincipal implements UserDetails{
    private Long id;
    private String username;
    transient private String password;
    private Collection<? extends GrantedAuthority> authorities;

    private UserPrincipal() {}

    public static UserPrincipal create(Student student) {
        return new UserPrincipal(
                student.getId(),
                student.getMatricNumber(),
                student.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_STUDENT"))
        );
    }

    public static UserPrincipal create(Teacher teacher) {
        return new UserPrincipal(
                teacher.getId(),
                Integer.toString(teacher.getStaffId()),
                teacher.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_TEACHER"))
        );
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
