package com.Group11Project.ClassAttendanceSystem.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AdminService {
    UserDetailsService userDetailsService();
}
